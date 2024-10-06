public class King extends ChessPiece{
    public King(String color){
        super(color);
    }
    @Override
    public String getColor(){
        return this.color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn) && checkPos(line) && checkPos(column)) {
            if(chessBoard.board[toLine][toColumn] != null) {
                if (this.color.equals(chessBoard.board[toLine][toColumn].getColor())) return false;
            }
            if(!((Math.abs(line-toLine)==1&&column==toColumn)||
                    (Math.abs(column-toColumn)==1&&line==toLine)||
                    (Math.abs(line-toLine)==1&&Math.abs(column-toColumn)==1))) return false;
        }
        return true;
    }
    public boolean isUnderAttack(ChessBoard board, int line, int column){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.board[i][j] != null) {
                    if (!board.board[i][j].getColor().equals(color) && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public String getSymbol(){
        return "K";
    }
    boolean checkPos(int position){
        if(position<0||position>7) return false;
        else return true;
    }
}
