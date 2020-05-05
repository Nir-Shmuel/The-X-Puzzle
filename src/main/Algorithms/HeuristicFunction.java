package main.Algorithms;

import main.States.State;

public interface HeuristicFunction<T extends State> {
    int apply(T state);

    void setGoalState(T goalState);
}
