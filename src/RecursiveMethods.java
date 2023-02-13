public class RecursiveMethods {
    // I really struggled to find a solution to this problem that was entirely
    // recursive and not partially iterative. After looking around the internet
    // for a bit I found some information that I previously did not know, which
    // is that method calls are added to a stack in java.
    public static void printStars(int n) {
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }

        System.out.print("\n");

        printStars(n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }

        System.out.print("\n");
    }

    public static int power(int base, int exponent) {
        if(exponent == 0) {
            return 1;
        }

        else if(exponent % 2 == 0) {
            return power(base * base, exponent/2);
        }

        else {
            return base * power(base * base, (exponent - 1) / 2);
        }
    }

    public static void showMines(char[][] board, int row, int col) {
        int nearbyMineCount = 0;

        // Step 1 - Check to see if row and column are valid
        if( col >= board.length || row >= board.length ) { return;}

        // Step 1 cont.
        else if ( col < 0 || row < 0 ) { return;}


        else {

            // Step 2 - Checks if cell has a number
            if( board[row][col] != '-' ) { return;}

            // Step 3 - Mine revealed
            // Game over/show board
            else if ( board[row][col] == '*' ){
                System.out.println(RecursiveMethods.boardToString(board));
            }

            // Step 4 - Checks for mine, otherwise gets nearby mine count
             else if ( board[row][col] != '*' ) {

                 // Step 5 - Checks if nearbyMineCount > 0, if so it updates the value
                if( nearbyMineCount > 0 ) {
                    board[row][col] = (char) nearbyMineCount;
                }

                else {

                    // Step 6 - Calls showMines on all adjacent tiles
                    showMines(board, row - 1, col - 1);
                    showMines(board, row - 1, col);
                    showMines(board, row -1 , col + 1);

                    showMines(board, row, col - 1);
                    showMines(board, row, col - 1);

                    showMines(board, row + 1, col);
                    showMines(board, row + 1, col);
                    showMines(board, row + 1, col + 1);
                }
             }
        }
    }

    public static int mineCount( char[][] board, int row, int col, boolean firstCall, int nearbyMineCount) {

        return nearbyMineCount;
    }

    public static char[][] createMineBoard(int length) {
        char[][] board = new char[length][length];
        int rand = 0;

        for( int i = 0; i < board.length; i++) {
            for( int j = 0; j < board.length; j++) {
                rand = ((int) ((Math.random() * 3) + 1));

                if(rand == 1) {
                    board[i][j] = '*';
                }
                else {
                    board[i][j] = '-';
                }
            }
        }

        return board;
    }

    public static String boardToString(char[][] b) {
        String out = "";

        for(int i = 0; i < b.length; i++) {
            for(int j = 0; j < b.length; j++) {
                out += "|" + b[i][j] + "|  ";
            }
            out += "\n";
        }

        return out;
    }
}