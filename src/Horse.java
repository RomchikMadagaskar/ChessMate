public class Horse extends ChessPiece{

    public Horse(String color){
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(checkPos(toLine)&&checkPos(toColumn)&&checkPos(line)&&checkPos(column)){
                int[][] positions = new int[][]{
                        {line - 2, column - 1}, {line - 2, column + 1},
                        {line + 2, column - 1}, {line + 2, column + 1},
                        {line - 1, column - 2}, {line - 1, column + 2},
                        {line + 1, column - 2}, {line + 1, column + 2}};

                for (int i = 0; i < positions.length; i++) {
                    if (positions[i][0] == toLine && positions[i][1] == toColumn){
                        if (chessBoard.board[toLine][toColumn] != null) {
                            if (!this.color.equals(chessBoard.board[toLine][toColumn].getColor())) return true;
                        } else {
                            return true;
                        }

                    }
                }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    boolean checkPos(int position){
        if(position<0||position>7) return false;
        else return true;
    }
}
