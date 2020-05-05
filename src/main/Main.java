package main;

import main.Algorithms.*;
import main.Operators.*;
import main.State.BoardState;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String srcFile = "input.txt";
        final String destFile = "output.txt";
        int algId;
        int n;
        int emptyRowIdx = 0;
        int emptyColidx = 0;

        SearchAlgorithm<BoardState> searchAlgorithm = null;
        // The operators, organized by priority.
        BoardOperator[] operators = new BoardOperator[]{new Up(), new Down(), new Left(), new Right()};

        try {
            Scanner scanner = new Scanner(new FileInputStream(srcFile));
            algId = Integer.parseInt(scanner.nextLine());
            switch (algId) {
                case 1:
                    searchAlgorithm = new IDS<>(operators, 100);
                    break;
                case 2:
                    searchAlgorithm = new BFS<>(operators);
                    break;
                case 3:
                    HeuristicFunction<BoardState> heuristicFunction = new ManhattanDistanceHeuristic();
                    searchAlgorithm = new AStar<>(operators, heuristicFunction);
                    break;

                default:
                    System.out.println("Wrong algorithm input! Number must be 1-main.Algorithms.IDS,2-main.Algorithms.BFS or 3-A*.");
                    System.exit(-1);
                    break;
            }

            // Set initial & goal board state.
            n = Integer.parseInt(scanner.nextLine());
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

            String solution = searchAlgorithm.search(init, goal);

            try {
                PrintWriter writer = new PrintWriter(destFile);
                writer.println(solution);
                writer.close();
                System.out.println(String.format("The solution is in file %s", destFile));
            } catch (IOException e) {
                System.out.println(String.format("Failed to open file. The solution is: %s", solution));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please try again.");
        }
    }

}
