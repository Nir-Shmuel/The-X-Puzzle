package main.States;

import java.util.Arrays;

public class BoardState implements State {
    private int[][] board;
    private int emptyRowIdx;
    private int emptyColIdx;

    public BoardState(int[][] board, int emptyRowIdx, int emptyColIdx) {
        this.board = board;
        this.emptyRowIdx = emptyRowIdx;
        this.emptyColIdx = emptyColIdx;
    }

    /*
     * Deep copy of the node's state
     */
    public State copyState() {
        int n = board.length;
        int[][] newBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            newBoard[i] = Arrays.copyOf(board[i], n);
        }
        return new BoardState(newBoard, this.emptyRowIdx, this.emptyColIdx);
    }

    public int[][] getBoard() {
        return board;
    }

    public int getEmptyRowIdx() {
        return emptyRowIdx;
    }

    public int getEmptyColIdx() {
        return emptyColIdx;
    }

    public void setEmptyIndexes(int emptyRowIdx, int emptyColIdx) {
        this.emptyRowIdx = emptyRowIdx;
        this.emptyColIdx = emptyColIdx;
    }

    /*
     * Compare two states by their board.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BoardState boardState = (BoardState) o;
        return this.hashCode() == boardState.hashCode();
    }

    /*
     * Create hashcode for each node, which depends on the node's state.
     */
    @Override
    public int hashCode() {
        StringBuilder builder = new StringBuilder();
        for (int[] row : this.board) {
            for (int x : row) {
                builder.append(String.format("%d-", x));
            }
        }
        return builder.toString().hashCode();
    }

    @Override
    public void printState() {
        for (int[] row : this.board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
