import java.util.Arrays;

public class Node {
    private Node parent;
    private int[][] state;
    private Character operator;
    int emptyRowIdx;
    int emptyColIdx;

    public Node(int[][] state, Character operator, Node parent, int emptyRowIdx, int emptyColidx) {
        this.state = state;
        this.operator = operator;
        this.parent = parent;
        this.emptyRowIdx = emptyRowIdx;
        this.emptyColIdx = emptyColidx;
    }

    public Character getOperator() {
        return operator;
    }

    public void setOperator(Character operator) {
        this.operator = operator;
    }

    public int[][] getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setState(int[][] state) {
        this.state = state;
    }

    //compare two nodes by their states
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return this.hashCode() == node.hashCode();
    }

    //create hashcode for each node, which depends on the node's state
    @Override
    public int hashCode() {
        StringBuilder builder = new StringBuilder();
        for (int[] row : this.state) {
            for (int x : row) {
                builder.append(String.format("%d-", x));
            }
        }
        return builder.toString().hashCode();
    }

    //deep copy of the node's state
    public int[][] copyState() {
        int[][] state = this.state;
        int n = state.length;
        int[][] newState = new int[n][n];
        for (int i = 0; i < n; i++) {
            newState[i] = Arrays.copyOf(state[i], n);
        }
        return newState;
    }

    //create the node after moving the empty cell up
    public Node createUp() {
        if (emptyRowIdx == 0)
            return null;
        int[][] newState = this.copyState();
        //move 0 up
        newState[emptyRowIdx][emptyColIdx] = newState[emptyRowIdx - 1][emptyColIdx];
        newState[emptyRowIdx - 1][emptyColIdx] = 0;
        return new Node(newState, 'U', this, emptyRowIdx - 1, emptyColIdx);
    }


    //create the node after moving the empty cell down
    public Node createDown() {
        int n = this.getState().length;
        if (emptyRowIdx == n - 1)
            return null;
        int[][] newState = this.copyState();
        //move 0 up
        newState[emptyRowIdx][emptyColIdx] = newState[emptyRowIdx + 1][emptyColIdx];
        newState[emptyRowIdx + 1][emptyColIdx] = 0;
        return new Node(newState, 'D', this, emptyRowIdx + 1, emptyColIdx);

    }

    //create the node after moving the empty cell right
    public Node createRight() {
        int n = this.getState().length;
        if (emptyColIdx == n - 1)
            return null;
        int[][] newState = this.copyState();
        //move 0 up
        newState[emptyRowIdx][emptyColIdx] = newState[emptyRowIdx][emptyColIdx + 1];
        newState[emptyRowIdx][emptyColIdx + 1] = 0;
        return new Node(newState, 'R', this, emptyRowIdx, emptyColIdx + 1);
    }

    //create the node after moving the empty cell left
    public Node createLeft() {
        if (emptyColIdx == 0)
            return null;
        int[][] newState = this.copyState();
        //move 0 up
        newState[emptyRowIdx][emptyColIdx] = newState[emptyRowIdx][emptyColIdx - 1];
        newState[emptyRowIdx][emptyColIdx - 1] = 0;
        return new Node(newState, 'L', this, emptyRowIdx, emptyColIdx - 1);
    }

    public void printNode() {
        System.out.println("parent: " + this.parent);
        System.out.println("operator: " + this.operator);
        System.out.println("state:");
        for (int[] row : this.state) {
            System.out.println(Arrays.toString(row));
        }
    }
}
