import java.util.*;

public class BFS<T extends State> extends SearchAlgorithm<T> {
    private Queue<Node<T>> open;

    public BFS(Operator<T>[] operators) {
        super(operators);
        this.open = new LinkedList<>();
    }

    @Override
    public void successors(Node<T> node) {
        for (int i = 0; i < this.operators.length; i++) {
            T currentState = node.getState();
            T createdState = this.operators[i].createNextState(currentState);
            if (createdState != null) {
                Node<T> n = new Node<T>(createdState, this.operators[i], node);
                this.open.add(n);
            }
        }
    }

    @Override
    public String search(Node<T> init, Node<T> goal) {
        this.open.clear();
        this.close.clear();
        this.open.add(init);
        while (!open.isEmpty()) {
            Node<T> nextNode = open.poll();
            if (!this.close.contains(nextNode) && !this.open.contains(nextNode)) {
                if (nextNode.equals(goal))
                    return path(nextNode);
                this.close.add(nextNode);
                this.successors(nextNode);
            }
        }
        return this.didNotFindSolution;
    }

}
