/**
 * Created by Uri on 26/04/2020
 */
public abstract class BoardOperator implements Operator {
    private BoardState currentState;
    private char direction;

    public BoardOperator(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    protected BoardState getCurrentState() {
        return currentState;
    }

    protected void setCurrentState(BoardState currentState) {
        this.currentState = currentState;
    }

    @Override
    public void printOperator() {
        System.out.println(this.direction);
    }
}
