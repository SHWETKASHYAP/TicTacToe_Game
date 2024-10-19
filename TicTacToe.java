import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++)
            board[i][j]=' ';
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.print("Player "+player+" enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col]==' '){
                board[row][col] = player;
                gameOver = haveWon(board,player);
                if(gameOver){
                    System.out.println("Player "+player+" has won.");
                }
                else{
                    if(player=='X')
                    player='O';
                    else
                    player='X';
                }
            }
            else{
                System.out.println("Invalid move. Try again! ");
            }
            if(!gameOver){
                gameOver = boardfull(board);
            if(gameOver)
            System.out.println("Game Over. Match Drawn");
            }
        }
        printBoard(board);
    }

    public static void printBoard(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++)
            System.out.print(board[i][j]+" |");
            System.out.println();
        }
    }

    public static boolean haveWon(char[][] board,char player){
        //check for rows
        for(int i=0;i<board.length;i++){
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player)
            return true;
        }

        //check for cols
        for(int i=0;i<board.length;i++){
            if(board[0][i]==player && board[1][i]==player && board[2][i]==player)
            return true;
        }

        //check for diagonals
        if((board[0][0]==player && board[1][1]==player && board[2][2]==player) || ((board[0][2]==player && board[1][1]==player && board[2][0]==player)))
        return true;

        return false;
    }

    public static boolean boardfull(char[][] board){

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==' ')
                return false;
            }
        }
        return true;
    }
}
