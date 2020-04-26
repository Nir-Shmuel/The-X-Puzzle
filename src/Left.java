import com.sun.corba.se.impl.io.TypeMismatchException;

/**
 * Created by Uri on 26/04/2020
 */
public class Left extends BoardOperator {

    public Left() {
        super('L');
    }

    //try to create the next State after moving the empty cell left, if fails return null
    @Override
    public State createNextState(State state) {
        if (state instanceof BoardState) {
            this.setCurrentState((BoardState) state);
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
            return newState;
        } else {
            throw new TypeMismatchException("The State is not a BoardState!");
        }

    }
}
