import java.util.*;

public class BFS extends SearchAlgorithm {
    private Queue<Node> open;

    public BFS() {
        super(new HashSet<>(), new Operator[]{new Down(), new Up(), new Left(), new Right()});
        this.open = new LinkedList<>();
    }

    @Override
    public List<Node> expand(Node node) {
        List<Node> successors = new ArrayList<>();
        for (int i = 0; i < this.operators.length; i++) {
            State currentState = node.getState();
            State createdState = this.operators[i].createNextState(currentState);
            if (createdState != null) {
                Node n = new Node(createdState, this.operators[i], node);
                successors.add(n);
            }
        }
        return successors;
    }

    @Override
    public String search(Node init, Node goal) {
//        int n_nodes = 0;
        this.open.clear();
        this.close.clear();
        this.open.add(init);
        while (!open.isEmpty()) {
            Node nextNode = open.poll();
            if (nextNode.equals(goal)) {
//                System.out.println("nodes:" + n_nodes);
                return path(nextNode);
            }
            this.close.add(nextNode);
            for (Node s : expand(nextNode)) {
                if (!findState(s, this.close) && !findState(s, this.open)) {
//                    n_nodes++;
                    if (s.equals(goal)) {
//                        System.out.println("nodes:" + n_nodes);
                        return path(s);
                    }
                    this.open.add(s);
                }
            }
        }
//        System.out.println("nodes:" + n_nodes);
        return "Did not find solution";
    }

}
