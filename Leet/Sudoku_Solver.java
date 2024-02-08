public class Sudoku_Solver {
    public static  boolean halper(char[][] board,int row,int col){
        if (row == board.length) {
            return true;
        }
        int nextRow = row;
        int nextCol = col+1;
        if (col == 8) {
            nextRow = row+1;
            nextCol = 0;
        }
        if (board[row][col] !='.' ) {
            return halper(board,nextRow,nextCol);
        }
        for (char i = '1'; i <='9' ; i++) {
            if (IsSafe(board,row,col,i)) {
                board[row][col]=i;
                if (halper(board,nextRow,nextCol)) {
                    return true;
                }
            }
            board[row][col]='.';
        }
        return false;
    }

    public static boolean IsSafe(char[][] board,int row,int col,char val){
        for (int i = 0; i <9 ; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        for (int i = 0; i <9 ; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }
        int gridRow = row/3*3;
        int gridCol = col/3*3;
        for (int i = gridRow; i <gridRow+3 ; i++) {
            for (int j = gridCol; j <gridCol+3 ; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        halper(board,0,0);
    }
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        Sudoku_Solver ss = new Sudoku_Solver();
        ss.solveSudoku(board);
        System.out.println();
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board.length ; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();

        }
    }
}
