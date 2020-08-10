package main.Algorithms;

import main.Node;
import main.Operators.Operator;
import main.States.State;

import java.util.PriorityQueue;

public class AStar<T extends State> extends SearchAlgorithm<T> {
    private PriorityQueue<Node<T>> open;
    private HeuristicFunction<T> hFunc;

    public AStar(Operator<T>[] operators, HeuristicFunction<T> heuristic) {
        super(operators);
        this.hFunc = heuristic;
    }

    /*
     * Add possible moves to open priority queue, according to the available operators.
     * If open already contains the same state, it will be updated to the minimum cost.
     * */
    @Override
    public void successors(Node<T> node) {
        for (int i = 0; i < this.operators.length; i++) {
            T currentState = node.getState();
            T createdState = this.operators[i].createNextState(currentState);
            if (createdState != null) {
                Node<T> newNode = new Node<>(createdState, this.operators[i], node, node.getDepth() + 1);
                if (open.contains(newNode)) {
                    open.removeIf(element -> element.equals(newNode) && element.getDepth() > newNode.getDepth());
                }
                this.open.add(newNode);
            }
        }
    }

    @Override
    public String search(Node<T> init, Node<T> goal) {
        close.clear();
        this.hFunc.setGoalState(goal.getState());
        this.open = new PriorityQueue<>((n1, n2) -> {
            int n1Dist = hFunc.apply(n1.getState());
            int f1 = n1.getDepth() + n1Dist;
            int n2Dist = hFunc.apply(n2.getState());
            int f2 = n2.getDepth() + n2Dist;
            return Integer.compare(f1, f2);
        });
        this.open.add(init);
        while (!open.isEmpty()) {
            Node<T> currentNode = open.poll();
            // Duplicate pruning the graph, by skipping states that the algorithm visited.
            if (close.contains(currentNode)) {
                continue;
            }
            if (currentNode.equals(goal)) {
                return this.path(currentNode);
            }
            this.close.add(currentNode);
            this.successors(currentNode);
        }

        return this.didNotFindSolution;
    }
}
