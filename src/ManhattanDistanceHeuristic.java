import java.util.HashMap;
import java.util.Map;

public class ManhattanDistanceHeuristic implements HeuristicFunction<BoardState> {
    private Map<Integer, int[]> indexMap;

    public ManhattanDistanceHeuristic() {
    }
    @Override
    public void setGoalState(BoardState goalState){
        indexMap = new HashMap<>();
        int n = goalState.getBoard().length;
        int[][] board = goalState.getBoard();
        // scan goal state board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                indexMap.put(board[i][j], new int[]{i, j});
            }
        }
    }

    @Override
    public int apply(BoardState boardState) {
        int n = boardState.getBoard().length;
        int[][] board = boardState.getBoard();
        int totalManDist = 0;
        // calculate Manhattan Distance in current state
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cellVal = board[i][j];
                int[] gXY = indexMap.get(cellVal);
                int gX = gXY[0];
                int gY = gXY[1];
                totalManDist += cellManDist(i, j, gX, gY);
            }
        }
        return totalManDist;
    }

    private int cellManDist(int cX, int cY, int gX, int gY) {
        return Math.abs(cX - gX) + Math.abs(cY - gY);
    }

}
