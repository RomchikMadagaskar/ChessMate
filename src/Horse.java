public class Horse extends ChessPiece{

    public Horse(String color){
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(checkPos(line)&&
                checkPos(column)&&
                checkPos(toLine)&&
                checkPos(toColumn))
        {
            if(line!=toLine&&column!=toColumn){

                int[][] endPosition= new int[][]{
                        {line + 2, column + 1}, {line - 2, column + 1},
                        {line+2,column-1},{line-2,column-1},
                        {line+1,column+2},{line-1,column+2},
                        {line+1,column-2},{line-1,column-2}
                };
                for(int i=0;i< endPosition.length;i++){
                    if(endPosition[i][0]==toLine&&endPosition[i][1]==toColumn) return true;
                }
            }
        } else return false;
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
    boolean checkPos(int position){
        if(position<0&&position>7) return false;
        else return true;
    }

}
