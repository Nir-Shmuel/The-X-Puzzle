import java.util.Arrays;
import java.util.Objects;

public class Node {
    private Node parent;
    private State state;
    private Operator operator;


    public Node(State state, Operator operator, Node parent) {
        this.state = state;
        this.operator = operator;
        this.parent = parent;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public State getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void printNode() {
        System.out.println("parent: " + this.parent);
        System.out.println("operator: ");
        if(this.operator != null){
            this.operator.printOperator();
        }
        System.out.println("state:");
        this.state.printState();
    }
    //compare two nodes with their
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return this.state.equals(node.state);
    }

}
