import java.util.Arrays;

/**
 * Created by Uri on 26/04/2020
 */
public class BoardState implements State {
    private int[][] board;
    private int emptyRowIdx;
    private int emptyColIdx;


    public BoardState(int[][] board, int emptyRowIdx, int emptyColIdx) {
        this.board = board;
        this.emptyRowIdx = emptyRowIdx;
        this.emptyColIdx = emptyColIdx;
    }

    //deep copy of the node's state
    public State copyState() {
        int n = board.length;
        int[][] newBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            newBoard[i] = Arrays.copyOf(board[i], n);
        }
        return new BoardState(newBoard, this.emptyRowIdx, this.emptyColIdx);
    }

    protected int[][] getBoard() {
        return board;
    }

    protected int getEmptyRowIdx() {
        return emptyRowIdx;
    }

    protected int getEmptyColIdx() {
        return emptyColIdx;
    }

    //compare two states by their board
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BoardState boardState = (BoardState) o;
//        int n=board.length;
//        for(int i=0;i<n;i++){
//            for(int j=0; j<n; j++){
//                if(board[i][j] != boardState.board[i][j])
//                    return false;
//            }
//        }
//        return true;
        return this.hashCode() == boardState.hashCode();
    }

    //create hashcode for each node, which depends on the node's state
    @Override
    public int hashCode() {
        StringBuilder builder = new StringBuilder();
        for (int[] row : this.board) {
            for (int x : row) {
                builder.append(String.format("%d-", x));
            }
        }
        return builder.toString().hashCode();
    }

    @Override
    public void printState() {
        for (int[] row : this.board) {
            System.out.println(Arrays.toString(row));
        }
    }


}