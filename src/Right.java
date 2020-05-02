public class Right extends BoardOperator {

    public Right() {
        super('R');
    }

    //try to create the next State after moving the empty cell left, if fails return null
    @Override
    public BoardState createNextState(BoardState state) {
        this.setCurrentState(state);
        int emptyRowIdx = this.getCurrentState().getEmptyRowIdx();
        int emptyColIdx = this.getCurrentState().getEmptyColIdx();
        if (emptyColIdx == 0) {
            return null;
        }
        BoardState newState = (BoardState) this.getCurrentState().copyState();
        int[][] newStateBoard = newState.getBoard();
        //move 0 left
        newStateBoard[emptyRowIdx][emptyColIdx] = newStateBoard[emptyRowIdx][emptyColIdx - 1];
        newStateBoard[emptyRowIdx][emptyColIdx - 1] = 0;
        newState.setEmptyIndexes(emptyRowIdx, emptyColIdx - 1);
        return newState;

    }
}
