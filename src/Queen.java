public class Queen extends ChessPiece{
    public Queen(String color){
        super(color);
    }
    @Override
    public String getColor(){
        return this.color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn) && checkPos(line) && checkPos(column)) {
            if(line==toLine&&column==toColumn) return false;
            if(chessBoard.board[toLine][toColumn] != null) {
                if (this.color.equals(chessBoard.board[toLine][toColumn].getColor())) return false;
            }
            if(!((line!=toLine&&column==toColumn)||(line==toLine&&column!=toColumn))) {
                if (!(Math.abs(line - toLine) == Math.abs(column - toColumn))) return false;
            }
            if(line!=toLine&&column==toColumn){
                if(line<toLine){
                    for (int i = line + 1; i < toLine; i++) {
                        if (chessBoard.board[i][column] != null) return false;
                    }
                }
                if (line > toLine) {
                    for (int i = line - 1; i > toLine; i--) {
                        if (chessBoard.board[i][column] != null) return false;
                    }
                }
            }
            if(line==toLine&&column!=toColumn) {
                if (column < toColumn) {
                    for (int i = column + 1; i < toColumn; i++) {
                        if (chessBoard.board[line][i] != null) return false;
                    }
                }
                if (column > toColumn) {
                    for (int i = column - 1; i > toColumn; i--) {
                        if (chessBoard.board[line][i] != null) return false;
                    }
                }
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
        }else return false;
        return true;
    }
    @Override
    public String getSymbol(){
        return "Q";
    }
    boolean checkPos(int position){
        if(position<0||position>7) return false;
        else return true;
    }
}
