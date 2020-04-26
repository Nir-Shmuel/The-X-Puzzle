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
        try {
            Scanner scanner = new Scanner(new FileInputStream(filePath));
            algId = Integer.parseInt(scanner.nextLine());
            // switch to choose alogorithm
            System.out.println(algId);

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
            Node init = new Node(new BoardState(initBoard,emptyRowIdx, emptyColidx), null, null);
            Node goal = new Node(new BoardState(goalBoard,n-1,n-1), null, null);
            init.printNode();
            goal.printNode();
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found. Please try again.");
        }
    }

}
