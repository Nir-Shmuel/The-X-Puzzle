package main.Algorithms;

import main.State.BoardState;

import java.util.HashMap;
import java.util.Map;

public class ManhattanDistanceHeuristic implements HeuristicFunction<BoardState> {
    private Map<Integer, int[]> indexMap;

    @Override
    public void setGoalState(BoardState goalState) {
        indexMap = new HashMap<>();
        int n = goalState.getBoard().length;
        int[][] board = goalState.getBoard();
        // Scan & keep goal state board on Hash Map to improve heuristic time-complexity.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                indexMap.put(board[i][j], new int[]{i, j});
            }
        }
    }

    /*
     * Calculate Manhattan distance from current state to goal state.
     */
    @Override
    public int apply(BoardState boardState) {
        int n = boardState.getBoard().length;
        int[][] board = boardState.getBoard();
        int totalManDist = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cellVal = board[i][j];
                int[] gXY = indexMap.get(cellVal);
                int gX = gXY[0];
                int gY = gXY[1];
                // Calculate Manhattan distance for specific cell.
                totalManDist += Math.abs(i - gX) + Math.abs(j - gY);
            }
        }
        return totalManDist;
    }

}
