package main.State;

public interface State {
    State copyState();

    void printState();
}
