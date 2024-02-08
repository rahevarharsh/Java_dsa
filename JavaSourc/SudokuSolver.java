public class SudokuSolver {


    public static boolean ISsafe(int arr[][],int row,int col,int val){
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i][col] == val) {
                return false;
            }
        }
        for (int i = 0; i< arr.length ; i++) {
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

    public static boolean solver(int arr[][],int row,int col){
        if (row== arr.length&&col== 0) {
            return true;
        }

        int nextRow = row,nextCol = col+1;
        if(col+1 == arr.length){
           nextCol = 0;
           nextRow = row+1;
        }
        if (arr[row][col] != 0) {
               return solver(arr,nextRow,nextCol);
        }
        for (int val = 1; val <= arr.length ; val++) {
            if (ISsafe(arr,row,col,val)) {
                arr[row][col]=val;
//                solver(arr,nextRow,nextCol);
                if (solver(arr,nextRow,nextCol) ) {
                    return true;
                }
                arr[row][col]=0;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int arr[][] = {   { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };
//        System.out.println(arr.length+" "+arr[0].length);
        System.out.println( solver(arr,0,0));
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
