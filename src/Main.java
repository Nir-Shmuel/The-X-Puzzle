import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String filePath = "input.txt";
        int algId;
        int n;
        int emptyRowIdx = 0;
        int emptyColidx = 0;
        BoardOperator[] operators = new BoardOperator[]{new Up(), new Down(), new Left(), new Right()};
        SearchAlgorithm<BoardState> searchAlgorithm = null;
        try {
            Scanner scanner = new Scanner(new FileInputStream(filePath));
            algId = Integer.parseInt(scanner.nextLine());
            System.out.println(algId);

            switch (algId) {
                case 1:
                    searchAlgorithm = new IDS<>(operators, 100);
                    break;
                case 2:
                    searchAlgorithm = new BFS<>(operators);
                    break;
                case 3:
                    HeuristicFunction<BoardState> heuristicFunction= new ManhattanDistanceHeuristic();
                    searchAlgorithm= new AStar<>(operators, heuristicFunction);
                    break;

                    default:
                        break;
                // continue
            }
            n = Integer.parseInt(scanner.nextLine());
            System.out.println(n);
            scanner.useDelimiter("-");
            int[][] initBoard = new int[n][n];
            int[][] goalBoard = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    initBoard[i][j] = scanner.nextInt();
                    if (initBoard[i][j] == 0) {
                        emptyRowIdx = i;
                        emptyColidx = j;
                    }
                    goalBoard[i][j] = i * n + j + 1;

                }
            }
            goalBoard[n - 1][n - 1] = 0;
            Node<BoardState> init = new Node<>(new BoardState(initBoard, emptyRowIdx, emptyColidx), null, null);
            Node<BoardState> goal = new Node<>(new BoardState(goalBoard, n - 1, n - 1), null, null);
            init.printNode();
            goal.printNode();
            long start = System.nanoTime();
            if (searchAlgorithm != null)
                System.out.println(searchAlgorithm.search(init, goal));
            else
                System.out.println("Wrong input!");
            System.out.println(System.nanoTime() - start);
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found. Please try again.");
        }
    }

}
