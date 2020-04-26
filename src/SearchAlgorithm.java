import java.util.Collection;
import java.util.List;
import java.util.Set;

public abstract class SearchAlgorithm {
    protected Collection<Node> close;
    protected Operator[] operators;

    public SearchAlgorithm(Collection<Node> close, Operator[] operators) {
        this.close = close;
        this.operators = operators;
    }

    //create all the reachable states from the current state
    public abstract List<Node> expand(Node node);

    //check if the state is in the collection
    public boolean findState(Node s, Collection<Node> collection) {
        for(Node n: collection){
            if(n.equals(s))
                return true;
        }
        return false;
    }

    //returns the path from initial state to goal
    public abstract String search(Node init, Node goal);

    protected String path(Node node) {
        StringBuilder builder = new StringBuilder();
        Node parent = node.getParent();
        while (parent != null) {
            builder.append(node.getOperator().getMove());
            node = parent;
            parent = node.getParent();
        }
        return builder.toString();
    }

}
