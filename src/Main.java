import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
            int[][] initState = new int[n][n];
            int[][] goalState = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    initState[i][j] = scanner.nextInt();
                    if (initState[i][j] == 0) {
                        emptyRowIdx = i;
                        emptyColidx = j;
                    }
                    goalState[i][j] = i * n + j + 1;

                }
            }
            goalState[n - 1][n - 1] = 0;
            Node init = new Node(initState, null, null, emptyRowIdx, emptyColidx);
            Node goal = new Node(goalState, null, null, n - 1, n - 1);
            init.printNode();
            goal.printNode();
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found. Please try again.");
        }
    }

}
