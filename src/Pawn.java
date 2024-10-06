public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }
    @Override
    public String getColor(){
        return this.color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        boolean isCheck=false;
        if(checkPos(toLine)&&checkPos(toColumn)&&checkPos(line)&&checkPos(column)){
            //if(line==toLine&&Math.abs(column-column)>1) return false;  //не ходит вбок
            //не ходит назад

            if(this.color.equals("White")){
                if(toLine<line) return false;
            }else {
                if(toLine>line) return false;
            }
//
//            if(chessBoard.board[toLine][toColumn] != null) {
//                if (this.color.equals(chessBoard.board[toLine][toColumn].getColor())) return false;
//            }


            if(Math.abs(line-toLine)==2&&column!=toColumn) return false;
//            if(line!=toLine){
//                for (int i = line + 1; i < toLine; i++) {
//                    if (chessBoard.board[i][column] != null) return false;
//                }
//            }
            if(Math.abs(column-toColumn)>1||Math.abs(line-toLine)>2)return false;
            if(Math.abs(column-toColumn)==1){
                if(chessBoard.board[toLine][toColumn] == null) return false;
                else {
                    if (this.color.equals(chessBoard.board[toLine][toColumn].getColor())) return false;
                }
            }
            if (this.color.equals("White")){
               if(toLine-line==1){
                   if (chessBoard.board[toLine][column] != null) return false;
               }
               if(toLine-line==2){
                   if(line!=1)return false;
                   if(column!=toColumn)return false;
                   if(chessBoard.board[2][toColumn] != null) return false;
                   if(chessBoard.board[3][toColumn] != null) return false;
               }
            }else{
                if(line-toLine==1){
                    if (chessBoard.board[toLine][column] != null) return false;
                }
                if(line-toLine==2){
                    if(line!=6)return false;
                    if(column!=toColumn)return false;
                    if(chessBoard.board[5][toColumn] != null) return false;
                    if(chessBoard.board[4][toColumn] != null) return false;
                }
            }

//            if(column==toColumn&&line!=toLine) {
//                if (this.color.equals("White")) {
//                    if ((toLine - line) == 1) {
//                        if(chessBoard.board[toLine][toColumn] != null) return false;
//                    }
//                    else {
//                        if (line == 1 && toLine == 3) {
//                            if(chessBoard.board[2][toColumn] != null) return false;
//                            if(chessBoard.board[3][toColumn] != null) return false;
//                        }
//                    }
//                } else {
//                    if ((toLine - line) == -1){
//                        if(chessBoard.board[toLine][toColumn] != null) return false;
//                    }
//                    else {
//                        if (line == 6 && toLine == 4) {
//                            if(chessBoard.board[5][toColumn] != null) return false;
//                            if(chessBoard.board[4][toColumn] != null) return false;
//                        }
//                    }
//                }
//            } else if (column!=toColumn&&line!=toLine) {
//                if(this.color.equals("White")){
//                    if(toLine==line+1&&(toColumn==column+1||toColumn==column-1)){
//                        if(!this.color.equals(chessBoard.board[toLine][toColumn].getColor())) return true;
//                        else return false;
//                    }
//                }else {
//                    if (toLine == line - 1 && (toColumn == column + 1 || toColumn == column - 1)) {
//                        if (!this.color.equals(chessBoard.board[toLine][toColumn].getColor())) return true;
//                        else return false;
//                    }
//                }
//            }

        }else return false;
        return true;
    }
    @Override
    public String getSymbol(){
        return "P";
    }
    boolean checkPos(int position){
        if(position<0||position>7) return false;
        else return true;
    }





}
