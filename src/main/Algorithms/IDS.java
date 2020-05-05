package main.Algorithms;

import main.Node;
import main.Operators.Operator;
import main.State.State;

public class IDS<T extends State> extends SearchAlgorithm<T> {
    private DFS_L<T> dfs_l;
    private int maxDepth;

    public IDS(Operator<T>[] operators, int maxDepth) {
        super(operators);
        this.maxDepth = maxDepth;
    }

    /*
     * Use the main.Algorithms.DFS_L successors method
     */
    @Override
    public void successors(Node<T> node) {
        this.dfs_l.successors(node);
    }

    /*
     * Call main.Algorithms.DFS_L for each limit in range: [0 : maxDepth)
     */
    @Override
    public String search(Node<T> init, Node<T> goal) {
        String result;
        for (int limit = 0; limit <= maxDepth; limit++) {
            this.dfs_l = new DFS_L<>(operators, limit);
            result = this.dfs_l.search(init, goal);
            if (!result.equals(this.didNotFindSolution)) {
                return result;
            }
        }
        return this.didNotFindSolution + " in limit: " + maxDepth;
    }
}
