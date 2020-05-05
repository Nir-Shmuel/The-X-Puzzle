package main.Operators;

import main.States.BoardState;

public class Down extends BoardOperator {

    public Down() {
        super('D');
    }

    /*
     * Try to create the next main.State.State after moving the empty cell up, if it fails return null.
     */
    @Override
    public BoardState createNextState(BoardState state) {
        this.setCurrentState(state);
        int emptyRowIdx = this.getCurrentState().getEmptyRowIdx();
        int emptyColIdx = this.getCurrentState().getEmptyColIdx();
        if (emptyRowIdx == 0) {
            return null;
        }
        BoardState newState = (BoardState) this.getCurrentState().copyState();
        int[][] newStateBoard = newState.getBoard();
        // Move 0 up
        newStateBoard[emptyRowIdx][emptyColIdx] = newStateBoard[emptyRowIdx - 1][emptyColIdx];
        newStateBoard[emptyRowIdx - 1][emptyColIdx] = 0;
        newState.setEmptyIndexes(emptyRowIdx - 1, emptyColIdx);
        return newState;
    }
}
