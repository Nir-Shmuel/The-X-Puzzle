/**
 * Created by Uri on 26/04/2020
 */
public interface Operator<T extends State> {
    T createNextState(T state) throws RuntimeException;

    void printOperator();

    String getMove();
}
