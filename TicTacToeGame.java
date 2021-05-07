import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playerOne, playerTwo;
        System.out.println("Enter the name of player one: ");
        playerOne = sc.nextLine();
        System.out.println("Enter the name of player two: ");
        playerTwo = sc.nextLine();
        int row, col;
        //row = col = 0;
        //Board
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        //Whose turns it is
        boolean isPlayerOne = true;

        //Ending Check
        boolean isGameEnded=false;

        while(!isGameEnded)
        {
            //Print the board
            displayingBoard(board);

            //Keeping track of symbol we will play
            char symbol;
            if (isPlayerOne) {
                symbol = 'X';
            } else {
                symbol = 'O';
            }
            //Printing whose turn it is.
            if (isPlayerOne) {
                System.out.println(playerOne + "'s Turn(X)");
            } else {
                System.out.println(playerTwo + "'s Turn(O)");
            }

            while (true) {
                System.out.println("Enter the row(0,1 and 2) and column(0,1 and 2) where you want to insert in the board: ");
                row = sc.nextInt();
                col = sc.nextInt();

                //Check for valid positions
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("Your row and columns are not valid inputs and are out of bounds of the board!!");
                } else if (board[row][col] != '-') {
                    System.out.println("There is already a symbol placed in that position!!");
                } else {
                    //Valid Inputs
                    break;
                }
            }
            board[row][col] = symbol;
            //displayingBoard(board);

            //Check Winner
            if (Winner(board) == 'X')
            {
                System.out.println(playerOne + " has Won");
                isGameEnded=true;
            }
            else if (Winner(board) == 'O')
            {
                System.out.println(playerTwo + " has Won");
                isGameEnded=true;
            }
            else
            {
                if (checkTie(board))
                {
                    System.out.println("It is a Tie!!!");
                    isGameEnded=true;
                }
                else
                {
                    //Toggling the turns
                    isPlayerOne=!isPlayerOne;
                }
            }
        }
        //Displaying the final Board
        displayingBoard(board);

    }

    public static void displayingBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char Winner(char[][] board)
    {
        //Row Check
        for(int i=0;i<3;i++)
        {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-')
            {
                return board[i][0];
            }
        }
        //Col Check
        for(int j=0;j<3;j++)
        {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] !='-')
            {
                return board[0][j];
            }
        }
        //Diagonal Check
        if(board[0][0]== board[1][1] && board[1][1] == board[2][2] && board[0][0]!= '-')
        {
            return board[0][0];
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-')
        {
            return  board[0][2];
        }

        //Tie Check
        return '-';
    }

    public static boolean checkTie(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j] == '-')
                {
                    return false;
                }
            }
        }
        return true;
    }

}
