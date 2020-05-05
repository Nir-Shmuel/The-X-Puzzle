package main.Operators;

import main.State.State;

public interface Operator<T extends State> {
    T createNextState(T state) throws RuntimeException;

    void printOperator();

    String getMove();
}
