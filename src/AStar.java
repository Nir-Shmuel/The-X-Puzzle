import java.util.PriorityQueue;
import java.util.Queue;

public class AStar<T extends State> extends SearchAlgorithm<T> {
    private Queue<Node<T>> open;
    private HeuristicFunction<T> heuristic;

    public AStar(Operator<T>[] operators, HeuristicFunction<T> heuristic) {
        super(operators);
        this.heuristic = heuristic;
    }

    @Override
    public void successors(Node<T> node) {

    }

    @Override
    public String search(Node<T> init, Node<T> goal) {
        this.heuristic.setGoalState(goal.getState());
        this.open = new PriorityQueue<>((n1, n2) -> {
            int n1Dist = heuristic.apply(n1.getState());
            int n2Dist = heuristic.apply(n2.getState());
            return Integer.compare(n1Dist, n2Dist);
        });
        return this.didNotFindSolution;
    }
}
