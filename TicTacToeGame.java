import java.util.*;
import java.util.Random;
import java.util.List;

public class TicTacToeGame{

    static ArrayList<Integer> HumanPositions=new ArrayList<Integer>();
    static ArrayList<Integer> AIPositions=new ArrayList<Integer>();
    

    public static void main(String[] args)
    {
        char[][] gameBoard= {{' ','|', ' ','|',' '},{'-','+', '-','+','-'},{' ','|', ' ','|',' '},{'-','+', '-','+','-'},{' ','|', ' ','|',' '}};
        printGameBoard(gameBoard);
        Scanner sc=new Scanner(System.in);
        

        // System.out.println(humanPosition);

        while(true)
        {
            System.out.println("Enter your placement from 1-9: ");
            int humanPosition=sc.nextInt();
            while(HumanPositions.contains(humanPosition) || AIPositions.contains(humanPosition))
            {
                System.out.println("Position already Taken!! Enter a correct postion now.");
                humanPosition=sc.nextInt();
            }

            placingOnTheBoard(humanPosition, gameBoard, "Human");

            String result=Winner();
            if(result.length() > 0)
            {
                System.out.println(result);
                break;
            }

            Random randomNumber= new Random();
            int aiPosition= randomNumber.nextInt(9) +1;
            while(HumanPositions.contains(aiPosition) || AIPositions.contains(aiPosition))
            {              
                aiPosition= randomNumber.nextInt(9) +1;
            }

            placingOnTheBoard(aiPosition, gameBoard, "Ai");
            printGameBoard(gameBoard);

            
            result=Winner();
            if(result.length() > 0)
            {
                System.out.println(result);
                break;
            }
        }
        
    }
    public static void printGameBoard(char[][] gameBoard)
    {
        for(char[] row: gameBoard)
        {
            for(char character: row)
            {
                System.out.print(character);
            }
            System.out.println();
        }
    }
    public static void placingOnTheBoard(int position, char[][] gameBoard, String user)
    {
        char symbol=' ';
        if(user.equals("Human"))
        {
            symbol='X';
            HumanPositions.add(position);
        }
        else if(user.equals("Ai"))
        {
            symbol='O';
            AIPositions.add(position);
        }
        switch(position)
        {
            case 1: 
                gameBoard[0][0]=symbol;
                break;
            case 2: 
                gameBoard[0][2]=symbol;
                break;
            case 3: 
                gameBoard[0][4]=symbol;
                break;
            case 4: 
                gameBoard[2][0]=symbol;
                break;
            case 5: 
                gameBoard[2][2]=symbol;
                break;
            case 6: 
                gameBoard[2][4]=symbol;
                break;
            case 7: 
                gameBoard[4][0]=symbol;
                break;
            case 8: 
                gameBoard[4][2]=symbol;
                break;
            case 9: 
                gameBoard[4][4]='X';
                break;
            default:
                break;
        }
    }
    public static String Winner()
    {
        List topRow= Arrays.asList(1,2,3);
        List midRow= Arrays.asList(4,5,6);
        List botRow= Arrays.asList(7,8,9);
        List leftCol= Arrays.asList(1,4,7);
        List midCol= Arrays.asList(2,5,8);
        List rightCol= Arrays.asList(3,6,9);
        List leftCross= Arrays.asList(1,5,9);
        List rightCross= Arrays.asList(3,5,7);
        

        List<List> winningPositions= new ArrayList<List>();
        winningPositions.add(topRow);
        winningPositions.add(midRow);
        winningPositions.add(botRow);
        winningPositions.add(leftCol);
        winningPositions.add(midCol);
        winningPositions.add(rightCol);
        winningPositions.add(leftCross);
        winningPositions.add(rightCross);

        for(List item: winningPositions)
        {
            if(HumanPositions.containsAll(item))
            {
                return "Congratulations you won!!";
            }
            else if(AIPositions.containsAll(item))
            {
                return "AI wins!! Better luck next time";
            }
            else if(HumanPositions.size() + AIPositions.size() == 9)
            {
                return "TIE!!!";
            }
        }
        return "";
    }

}