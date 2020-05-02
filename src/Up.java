public class Up extends BoardOperator {

    public Up() {
        super('U');
    }

    //try to create the next State after moving the empty cell down, if fails return null
    @Override
    public BoardState createNextState(BoardState state) {
        this.setCurrentState(state);
        int n = this.getCurrentState().getBoard().length;
        int emptyRowIdx = this.getCurrentState().getEmptyRowIdx();
        int emptyColIdx = this.getCurrentState().getEmptyColIdx();
        if (emptyRowIdx == n - 1) {
            return null;
        }
        BoardState newState = (BoardState) this.getCurrentState().copyState();
        int[][] newStateBoard = newState.getBoard();
        //move 0 down
        newStateBoard[emptyRowIdx][emptyColIdx] = newStateBoard[emptyRowIdx + 1][emptyColIdx];
        newStateBoard[emptyRowIdx + 1][emptyColIdx] = 0;
        newState.setEmptyIndexes(emptyRowIdx + 1, emptyColIdx);
        return newState;
    }
}
