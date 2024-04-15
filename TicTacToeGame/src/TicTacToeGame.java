import java.util.Scanner;
public class TicTacToeGame {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    
	public static void main(String[] args) {
		 initializeBoard();
	        displayBoard();
	        System.out.println("Welcome to Tic Tac Toe!\n");
	        System.out.println("Rules: Make your move by entering the row and column numbers (0-2).\n");

	        try(Scanner Number = new Scanner(System.in);){
	        boolean gameOver = false;

	        while (!gameOver) {
	            System.out.print("Player " + currentPlayer + ", enter your move (row column): ");
	            int row = Number.nextInt();
	            int col = Number.nextInt();

	            if (isValidMove(row, col)) {
	                board[row][col] = currentPlayer;
	                displayBoard();
	                if (checkWin()) {
	                    System.out.println("Player " + currentPlayer + " wins!");
	                    gameOver = true;
	                } else if (isBoardFull()) {
	                    System.out.println("It's a tie!");
	                    gameOver = true;
	                } else {
	                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	                }
	            } else {
	                System.out.println("Invalid move. Please try again.");
	            }
	        }

	        System.out.print("Do you want to play again? (yes/no): ");
	        String playAgain = Number.next();
	        if (playAgain.equalsIgnoreCase("yes")) {
	            resetGame();
	            main(null);
	        }
	      }
	    }

	    private static void initializeBoard() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = '-';
	            }
	        }
	    }

	    private static void displayBoard() {
	        System.out.println("  0 1 2");
	        for (int i = 0; i < 3; i++) {
	            System.out.print(i + " ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }

	    private static boolean isValidMove(int row, int col) {
	        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
	    }

	    private static boolean checkWin() {
	        for (int i = 0; i < 3; i++) {
	            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
	                return true; 
	            }
	            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
	                return true; 
	            }
	        }
	        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
	            return true; 
	        }
	        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
	            return true; 
	        }
	        return false;
	    }

	    private static boolean isBoardFull() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == '-') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    private static void resetGame() {
	        initializeBoard();
	        currentPlayer = 'X';

	}

}
