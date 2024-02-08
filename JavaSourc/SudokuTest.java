public class SudokuTest {
    public static boolean IsSafe(int arr[][],int row,int col,int val){
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i][col] == val) {
                return false;
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            if (arr[row][i] == val) {
                return false;
            }
        }
        int boxrow = (row/3)*3;
        int boxcol = (col/3)*3;

        for (int i = boxrow; i <boxrow+3 ; i++) {
            for (int j = boxcol; j <boxcol+3 ; j++) {
                if (arr[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean solver(int arr[][],int row,int col) {
        if (row == arr.length) {
            return true;
        }

        int nextRow = row,nextCol = col+1;
        if (col+1 == arr.length) {
            nextRow = row+1;
            nextCol = 0;
        }
        if (arr[row][col] != 0) {
            return solver(arr,nextRow,nextCol);
        }
        for (int val = 1; val <= arr.length ; val++) {
            if (IsSafe(arr,row,col,val)) {
                arr[row][col]=val;
                if (solver(arr,nextRow,nextCol)) {
                    return true;
                }
                arr[row][col]=0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int sudoku[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                          {5, 2, 0, 0, 0, 0, 0, 0, 0},
                          {0, 8, 7, 0, 0, 0, 0, 3, 1},
                          {0, 0, 3, 0, 1, 0, 0, 8, 0},
                          {9, 0, 0, 8, 6, 3, 0, 0, 5},
                          {0, 5, 0, 0, 9, 0, 6, 0, 0},
                          {1, 3, 0, 0, 0, 0, 2, 5, 0},
                          {0, 0, 0, 0, 0, 0, 0, 7, 4},
                          {0, 0, 5, 2, 0, 6, 3, 0, 0}
                         };
        System.out.println(solver(sudoku,0,0));
        for (int i = 0; i < sudoku.length ; i++) {
            for (int j = 0; j < sudoku.length ; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
}
