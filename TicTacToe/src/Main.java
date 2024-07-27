import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        char[][] board = new char[3][3];
        Scanner input = new Scanner(System.in);
        boolean gameOver = false;
        char player = 'X';

        // initializing board matrix
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }

        //main loop
        while(!gameOver){
            drawBoard(board);
            System.out.println("Player " + player + " Turn: ");
            System.out.println("Enter Move(Player " + player + "): ");
            int row = input.nextInt();
            int col = input.nextInt();
            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = isGameWon(board, player);
                if(gameOver){
                    System.out.println("Player " + player + " Won!!!");
                }else{
                    player = (player == 'X') ? 'O' : 'X';
                }
            }else{
                System.out.println("Invalid Move, Try Again!");
            }
        }
        drawBoard(board);
    }

    public static void drawBoard(char[][] board){
        for (char[] chars : board) {
            for (char character : chars) {
                System.out.print(character + " | ");
            }
            System.out.println();
        }
    }

    public static boolean isGameWon(char[][] board, char player){
        for(int i = 0; i < board.length; ++i){
            //check for rows
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            //check for columns
            if(board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
            //check for diagonals
            if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
                return true;
            if(board[0][2] == player && board[1][1] == player && board[2][0] == player)
                return true;
        }
        return false;
    }
}
