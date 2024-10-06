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

        if(checkPos(toLine)&&checkPos(toColumn)&&checkPos(line)&&checkPos(column)){
            if(this.color.equals("White")){
                if(toLine<line) return false;
            }else {
                if(toLine>line) return false;
            }
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
