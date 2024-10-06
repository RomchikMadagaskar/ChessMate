public class Bishop extends ChessPiece {
    public Bishop(String color){
        super(color);
    }
    @Override
    public String getColor(){
        return this.color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        boolean isCheck = false;
        if(checkPos(toLine)&&checkPos(toColumn)&&checkPos(line)&&checkPos(column)) {

            if (!(Math.abs(line - toLine) == Math.abs(column - toColumn))) return false;

            if(chessBoard.board[toLine][toColumn] != null) {
                if (this.color.equals(chessBoard.board[toLine][toColumn].getColor())) return false;
            }

            if(line>toLine&&column>toColumn){
                int j=column-1;
                for(int i=line-1;i>toLine;i--){
                    if(chessBoard.board[i][j] != null) return false;
                    j--;
                }
            }
            if(line>toLine&&column<toColumn){
                int j=column+1;
                for(int i=line-1;i>toLine;i--){
                    if(chessBoard.board[i][j] != null) return false;
                    j++;
                }
            }
            if(line<toLine&&column<toColumn){
                int j=column+1;
                for(int i=line+1;i<toLine;i++){
                    if(chessBoard.board[i][j] != null) return false;
                    j++;
                }
            }
            if(line<toLine&&column>toColumn){
                int j=column-1;
                for(int i=line+1;i<toLine;i++){
                    if(chessBoard.board[i][j] != null) return false;
                    j--;
                }
            }
        }
        return true;
    }
    @Override
    public String getSymbol(){
        return "B";
    }
    boolean checkPos(int position){
        if(position<0||position>7) return false;
        else return true;
    }
}
