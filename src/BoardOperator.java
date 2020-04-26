/**
 * Created by Uri on 26/04/2020
 */
public abstract class BoardOperator implements Operator {
    private BoardState currentState;
    private char move;

    public BoardOperator(char direction) {
        this.move = direction;
    }

    @Override
    public String getMove() {
        return String.valueOf(move);
    }

    public char getDirection() {
        return move;
    }

    protected BoardState getCurrentState() {
        return currentState;
    }

    protected void setCurrentState(BoardState currentState) {
        this.currentState = currentState;
    }

    @Override
    public void printOperator() {
        System.out.println(this.move);
    }
}
