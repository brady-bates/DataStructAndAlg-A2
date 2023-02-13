import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] board = RecursiveMethods.createMineBoard(5);

        System.out.println(RecursiveMethods.boardToString(board));

        RecursiveMethods.showMines(board, 0, 0);

        System.out.println(RecursiveMethods.boardToString(board));

        //Assignment2Checks.checkProblem1((int)(Math.random() * 20 ));
        //Assignment2Checks.checkProblem2(((int)(Math.random() * 5 )) , ((int)(Math.random() * 5 )));

        //RecursiveMethods.printStars(Integer.parseInt(scan.nextLine()));

        //System.out.println(RecursiveMethods.power(2, 3));
    }
}