public class Node<T extends State> {
    private Node<T> parent;
    private T state;
    private Operator<T> operator;
    private int depth;

    public Node(T state, Operator<T> operator, Node<T> parent, int depth) {
        this.parent = parent;
        this.state = state;
        this.operator = operator;
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public Node(T state, Operator<T> operator, Node<T> parent) {
        this.state = state;
        this.operator = operator;
        this.parent = parent;
        this.depth = 0;
    }

    public Operator<T> getOperator() {
        return operator;
    }

    public void setOperator(Operator<T> operator) {
        this.operator = operator;
    }

    public T getState() {
        return state;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void setState(T state) {
        this.state = state;
    }

    public void printNode() {
        if (this.parent != null)
            System.out.println("parent: " + this.parent);
        if (this.operator != null) {
            System.out.println("operator: ");
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
        Node<T> node = (Node<T>) o;
        return this.state.equals(node.state);
    }
}
