import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        System.out.print("Player 1 whats your name?");
        String p1 = in.nextLine();
        System.out.print("Player 2 whats your name?");
        String p2 = in.nextLine();

        //сделаем поле
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';

            }
        }
        boolean isPlayer1 = true;

        boolean gameEnded = false;
        while(!gameEnded) {
            drawBoard(board);

            char symbol = ' ';
            if (isPlayer1) {
                symbol = 'x';
            } else {
                symbol = 'o';
            }
            if (isPlayer1) {
                System.out.println(p1 + "`s turn(x)");
            } else {
                System.out.println(p2 + "`s turn(o)");
            }


            int row = 0;
            int col = 0;

            while (true) {
                System.out.print("Enter a row(0,1 or 2):");
                row = in.nextInt();
                System.out.print("Enter a col(0,1 or 2):");
                col = in.nextInt();

                //далее проверяем пределы row И col
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("Row and col out of bounds");
                } else if (board[row][col] != '-') {//проверка на пустоту поля
                    System.out.println("Someone already has a move here");
                } else {
                    break;
                }

            }
            board[row][col] = symbol;
            if (hasWon(board) == 'x') {
                System.out.println(p1 + "has won");
            } else if (hasWon(board) == 'o') {
                System.out.println(p2 + "has won");
            } else {

                if (hasTied(board)) {
                    System.out.println("Its a tie");
                } else {
                    isPlayer1 = !isPlayer1;

                }
            }
        }

    }

    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char hasWon(char[][] board) {
        //row
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[1][0] != '-') {
                return board[i][0];
            }
        }
        //col
        for (int j = 0; j<3;j++){
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] !='-'){
                return board[0][j];
            }
        }
        //диагонали
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] !='-'){
            return board[0][0];//диагональ с правого верхнего до левого нижнего
        }
        if(board[2][0]== board[1][1] && board[1][1] == board[0][2]&& board[2][0]!='-'){
            return board[2][0];//диагональ с верхнего левого до правого нижнего
        }
        //нет победителей
        return '-';
    }
    //проверка полной доски
    public static boolean hasTied(char[][] board){
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if (board[i][j]=='-'){
                    return false;
                }
            }
        }
        return true;
    }

}