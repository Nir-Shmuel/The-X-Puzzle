import com.sun.corba.se.impl.io.TypeMismatchException;

/**
 * Created by Uri on 26/04/2020
 */
public class Down extends BoardOperator {

    public Down() {
        super('D');
    }

    //try to create the next State after moving the empty cell down, if fails return null
    @Override
    public State createNextState(State state) {
        if (state instanceof BoardState) {
            this.setCurrentState((BoardState) state);
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
        } else {
            throw new TypeMismatchException("The State is not a BoardState!");
        }
    }
}
