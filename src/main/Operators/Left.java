package main.Operators;

import main.State.BoardState;

public class Left extends BoardOperator {

    public Left() {
        super('L');
    }

    /*
     * Try to create the next main.State.State after moving the empty cell right, if fails return null.
     */
    @Override
    public BoardState createNextState(BoardState state) {
        this.setCurrentState(state);
        int n = this.getCurrentState().getBoard().length;
        int emptyRowIdx = this.getCurrentState().getEmptyRowIdx();
        int emptyColIdx = this.getCurrentState().getEmptyColIdx();
        if (emptyColIdx == n - 1) {
            return null;
        }
        BoardState newState = (BoardState) this.getCurrentState().copyState();
        int[][] newStateBoard = newState.getBoard();
        // Move 0 right.
        newStateBoard[emptyRowIdx][emptyColIdx] = newStateBoard[emptyRowIdx][emptyColIdx + 1];
        newStateBoard[emptyRowIdx][emptyColIdx + 1] = 0;
        newState.setEmptyIndexes(emptyRowIdx, emptyColIdx + 1);
        return newState;
    }
}
