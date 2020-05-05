package main.Algorithms;

import main.State.State;

public interface HeuristicFunction<T extends State> {
    int apply(T state);

    void setGoalState(T goalState);
}
