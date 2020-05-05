package main.States;

public interface State {
    State copyState();

    void printState();
}
