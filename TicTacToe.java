import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    private static final char[] SYMBOLS = {' ', 'X', 'O'};
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private static Scanner scanner = new Scanner(System.in);
    private static int currentPlayer = 1;

    public static void main(String[] args) {
        while (true) {
            printBoard();
            System.out.print("Gracz " + currentPlayer + ", wprowadź wiersz i kolumnę (np. 2 3): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row < 1 || row > BOARD_SIZE || col < 1 || col > BOARD_SIZE) {
                System.out.println("Niepoprawne współrzędne, spróbuj ponownie.");
                continue;
            }
            if (board[row - 1][col - 1] != 0) {
                System.out.println("To pole jest już zajęte, spróbuj ponownie.");
                continue;
            }
            board[row - 1][col - 1] = currentPlayer;
            if (checkWin()) {
                printBoard();
                System.out.println("Gracz " + currentPlayer + " wygrał!");
                break;
            }
            if (checkDraw()) {
                printBoard();
                System.out.println("Remis!");
                break;
            }
            currentPlayer = currentPlayer % 2 + 1;
        }
    }

    private static boolean checkWin() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(SYMBOLS[board[i][j]] + " ");
            }
            System.out.println();
        }
    }
}
