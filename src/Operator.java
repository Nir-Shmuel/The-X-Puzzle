/**
 * Created by Uri on 26/04/2020
 */
public interface Operator {
    State createNextState(State state);
    void printOperator();
}
