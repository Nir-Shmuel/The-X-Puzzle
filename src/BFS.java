import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS extends SearchAlgorithm {
    public BFS() {
        super(new ArrayDeque<>(), new HashSet<>());
    }

    @Override
    public Set<Node> expand(Node node) {
        HashSet<Node> successors = new HashSet<>();
        Node up = node.createUp();
        if (up != null)
            successors.add(up);
        Node down = node.createDown();
        if (down != null)
            successors.add(down);
        Node right = node.createRight();
        if (right != null)
            successors.add(right);
        Node left = node.createLeft();
        if (left != null)
            successors.add(left);
        return successors;
    }

    @Override
    public String search(Node init, Node goal) {
        return null;
    }
}
