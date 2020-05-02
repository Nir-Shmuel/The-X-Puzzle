import java.util.*;

public class DFS_L<T extends State> extends SearchAlgorithm<T> {
    private Stack<Node<T>> open;
    private int limit;

    public DFS_L(Operator<T>[] operators, int limit) {
        super(operators);
        this.open = new Stack<>();
        this.limit = limit;
    }

    @Override
    public void successors(Node<T> node) {
        // push to stack: less priority first
        for (int i = this.operators.length - 1; i >= 0; i--) {
            T currentState = node.getState();
            T createdState = this.operators[i].createNextState(currentState);
            if (createdState != null) {
                Node<T> n = new Node<T>(createdState, this.operators[i], node, node.getDepth() + 1);
                this.open.push(n);
            }
        }
    }

    @Override
    public String search(Node<T> init, Node<T> goal) {
        this.open.clear();
        this.close.clear();
        this.open.push(init);
        while (!this.open.isEmpty()) {
            Node<T> v = this.open.pop();
            if (!this.close.contains(v) && !this.open.contains(v)) {
                if (v.equals(goal))
                    return this.path(v) + " depth="+ v.getDepth();
                this.close.add(v);
                if (v.getDepth() < this.limit)
                    this.successors(v);
            }
        }
        return this.didNotFindSolution;
    }
}
