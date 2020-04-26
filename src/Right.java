import com.sun.corba.se.impl.io.TypeMismatchException;

/**
 * Created by Uri on 26/04/2020
 */
public class Right extends BoardOperator {

    public Right() {
        super('R');
    }

    //try to create the next State after moving the empty cell right, if fails return null
    @Override
    public State createNextState(State state) {
        if (state instanceof BoardState) {
            this.setCurrentState((BoardState) state);
            int n = this.getCurrentState().getBoard().length;
            int emptyRowIdx = this.getCurrentState().getEmptyRowIdx();
            int emptyColIdx = this.getCurrentState().getEmptyColIdx();
            if (emptyColIdx == n - 1) {
                return null;
            }
            BoardState newState = (BoardState) this.getCurrentState().copyState();
            int[][] newStateBoard = newState.getBoard();
            //move 0 right
            newStateBoard[emptyRowIdx][emptyColIdx] = newStateBoard[emptyRowIdx][emptyColIdx + 1];
            newStateBoard[emptyRowIdx][emptyColIdx + 1] = 0;
            newState.setEmptyIndexes(emptyRowIdx, emptyColIdx + 1);
            return newState;
        } else {
            throw new TypeMismatchException("The State is not a BoardState!");
        }
    }
}
