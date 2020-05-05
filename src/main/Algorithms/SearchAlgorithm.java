package main.Algorithms;

import main.Node;
import main.Operators.Operator;
import main.State.State;

import java.util.HashSet;
import java.util.Set;

public abstract class SearchAlgorithm<T extends State> {
    protected Set<Node<T>> close;
    protected Operator<T>[] operators;
    final protected String didNotFindSolution = "Did not find solution";

    public SearchAlgorithm(Operator<T>[] operators) {
        this.close = new HashSet<>();
        this.operators = operators;
    }

    /*
     * Create all the reachable states from the current state.
     */
    public abstract void successors(Node<T> node);

    /*
     * Returns the path from initial state to goal.
     */
    public abstract String search(Node<T> init, Node<T> goal);

    /*
     * Returns the operators order from the initial state to goal.
     */
    protected String path(Node<T> node) {
        StringBuilder builder = new StringBuilder();
        Node<T> parent = node.getParent();
        while (parent != null) {
            builder.insert(0, node.getOperator().getMove());
            node = parent;
            parent = node.getParent();
        }
        return builder.toString();
    }
}
