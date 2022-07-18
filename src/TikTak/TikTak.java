package TikTak;

import java.util.Objects;
import java.util.Scanner;

class TikTak {

    private int turnCounter = 0;
    private final String[][] board = {{"-", "-", "-"},
            {"-", "-", "-"},
            {"-", "-", "-"}};

    public static void main(String[] args) {
        TikTak test = new TikTak();
        test.playAIVsAI();
    }

    private void play() {
        boolean flag = true;

        while (!isGameWon()) {
            if(turnCounter == 9){
                System.out.println("Tie");
                break;
            }else {
                turnCounter++;
            }
            if (flag) {
                addX();
                flag = !flag;
            } else {
                addO();
                flag = !flag;
            }
        }
    }
    void playVsAI() {
        boolean flag = true;

        while (!isGameWon()) {
            if(turnCounter == 9){
                System.out.println("Tie");
                break;
            }else {
                turnCounter++;
            }
            if (flag) {
                addX();
                flag = !flag;
            } else {
                AIY();
                flag = !flag;
            }
        }
    }

    void playAIVsAI() {
        boolean flag = true;

        while (!isGameWon()) {
            if(turnCounter == 9){
                System.out.println("Tie");
                break;
            }else {
                turnCounter++;
            }
            if (flag) {
                AIX();
                flag = !flag;
            } else {
                AIY();
                flag = !flag;
            }
        }
    }


    private void addX() {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        while (true) {
            System.out.println("X Turn");
            System.out.println("Enter your x");
            x = scanner.nextInt();
            System.out.println("Enter your Y");
            y = scanner.nextInt();
            scanner.nextLine();
            if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
                if (board[x][y].equals("-")) {
                    board[x][y] = "X";
                    printBoard();
                    break;
                } else {
                    System.out.println("This tile is taken");
                    printBoard();
                }
            } else {
                System.out.println("Tile out of bounds");
            }
        }
    }

    private void addO() {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        while (true) {
            System.out.println("0 Turn");
            System.out.println("Enter your x");
            x = scanner.nextInt();
            System.out.println("Enter your Y");
            y = scanner.nextInt();
            scanner.nextLine();
            if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
                if (board[x][y].equals("-")) {
                    board[x][y] = "O";
                    printBoard();
                    break;
                } else {
                    System.out.println("This tile is taken");
                    printBoard();
                }
            } else {
                System.out.println("Tile out of bounds");
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("-------");
    }

    private Boolean isGameWon() {

        // ---1
        if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) && !board[0][0].equals("-")) {
            System.out.println("Won " + board[0][0]);
            return true;
        }
        // ---2
        else if ((board[1][0].equals(board[1][1]) && Objects.equals(board[1][1], board[1][2])) && !board[1][0].equals("-")) {
            System.out.println("Won " + board[1][0]);
            return true;
        } // --- 3
        else if ((board[2][0].equals(board[2][1]) && Objects.equals(board[2][1], board[2][2])) && !board[2][0].equals("-")) {
            System.out.println("Won " + board[2][0]);
            return true;
        }// |1
        else if ((board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])) && !board[0][1].equals("-")) {
            System.out.println("Won " + board[0][1]);
            return true;
        }
        // |2
        else if ((board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])) && !board[0][2].equals("-")) {
            System.out.println("Won " + board[0][2]);
            return true;
        }
        // |3
        else if ((board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) && !board[0][0].equals("-")) {
            System.out.println("Won " + board[0][0]);
            return true;
        }// \
        else if ((board[0][0].equals(board[1][1]) && Objects.equals(board[1][1], board[2][2])) && !board[0][0].equals("-")) {
            System.out.println("Won " + board[0][0]);
            return true;
        }// \
        else if ((board[0][2].equals(board[1][1]) && Objects.equals(board[1][1], board[2][0])) && !board[0][2].equals("-")) {
            System.out.println("Won " + board[0][2]);
            return true;
        }



        /*ArrayList<String[][]> winingConditionsX = new ArrayList<>();
        //Wining conditions X
        String[][] testingBoard;
        {
            testingBoard = new String[][]{{"X", "X", "X"},
                    {"", "", ""},
                    {"", "", ""}};
            winingConditionsX.add(testingBoard);
            testingBoard = new String[][]{{"", "", ""},
                    {"X", "X", "X"},
                    {"", "", ""}};
            winingConditionsX.add(testingBoard);
            testingBoard = new String[][]{{"", "", ""},
                    {"", "", ""},
                    {"X", "X", "X"}};
            winingConditionsX.add(testingBoard);
            testingBoard = new String[][]{{"X", "", ""},
                    {"X", "", ""},
                    {"X", "", ""}};
            winingConditionsX.add(testingBoard);
            testingBoard = new String[][]{{"", "X", ""},
                    {"", "X", ""},
                    {"", "X", ""}};
            winingConditionsX.add(testingBoard);
            testingBoard = new String[][]{{"", "", "X"},
                    {"", "", "X"},
                    {"", "", "X"}};
            winingConditionsX.add(testingBoard);
            testingBoard = new String[][]{{"X", "", ""},
                    {"", "X", ""},
                    {"", "", "X"}};
            winingConditionsX.add(testingBoard);
            testingBoard = new String[][]{{"", "", "X"},
                    {"", "X", ""},
                    {"X", "", ""}};
            winingConditionsX.add(testingBoard);
        }

        ArrayList<String[][]> winingConditionsY = new ArrayList<>();
        //Wining conditions X
        {
            testingBoard = new String[][]{{"0", "0", "0"},
                    {"", "", ""},
                    {"", "", ""}};
            winingConditionsY.add(testingBoard);
            testingBoard = new String[][]{{"", "", ""},
                    {"0", "0", "0"},
                    {"", "", ""}};
            winingConditionsY.add(testingBoard);
            testingBoard = new String[][]{{"", "", ""},
                    {"", "", ""},
                    {"0", "0", "0"}};
            winingConditionsY.add(testingBoard);
            testingBoard = new String[][]{{"0", "", ""},
                    {"0", "", ""},
                    {"0", "", ""}};
            winingConditionsY.add(testingBoard);
            testingBoard = new String[][]{{"", "0", ""},
                    {"", "0", ""},
                    {"", "0", ""}};
            winingConditionsY.add(testingBoard);
            testingBoard = new String[][]{{"", "", "0"},
                    {"", "", "0"},
                    {"", "", "0"}};
            winingConditionsY.add(testingBoard);
            testingBoard = new String[][]{{"0", "", ""},
                    {"", "0", ""},
                    {"", "", "0"}};
            winingConditionsY.add(testingBoard);
            testingBoard = new String[][]{{"", "", "0"},
                    {"", "0", ""},
                    {"0", "", ""}};
            winingConditionsY.add(testingBoard);
        }

        for (String[][] checkX: winingConditionsX
             ) {
            if(board == checkX){
                System.out.println("X won");
                printBoard();
                return true;
            }
        }
        for (String[][] checkY: winingConditionsY
        ) {
            if(board == checkY){
                System.out.println("Y won");
                printBoard();
                return true;
            }
        }*/
        return false;
    }

    void AIY(){
        int choice;
        int[][] options = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        while (true) {
            choice = (int) ((Math.random() * (8)));{
                if (board[options[choice][0]][options[choice][1]].equals("-")) {
                    System.out.println("AI 0 turn");
                    board[options[choice][0]][options[choice][1]] = "0";
                    printBoard();
                    break;
                }
            }
        }
    }
    void AIX(){
        int choice;
        int[][] options = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        while (true) {
            choice = (int) ((Math.random() * (8)));{
                if (board[options[choice][0]][options[choice][1]].equals("-")) {
                    System.out.println("AI X turn");
                    board[options[choice][0]][options[choice][1]] = "X";
                    printBoard();
                    break;
                }
            }
        }
    }
}
