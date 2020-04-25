import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public abstract class SearchAlgorithm {
    protected Collection<Node> open;
    protected Collection<Node> close;

    public SearchAlgorithm(Collection<Node> open, Collection<Node> close) {
        this.open = open;
        this.close = close;
    }

    //create all the reachable states from the current state
    public abstract Set<Node> expand(Node node);

    //check if the state is in the collection
    public boolean findState(Node s, Collection<Node> collection) {
        return collection.contains(s);
    }

    //returns the path from initial state to goal
    public abstract String search(Node init, Node goal);

}
