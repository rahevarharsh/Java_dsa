import java.util.HashSet;

public class SetMatrixZeroes {

    public void halper(int [][]matrix,int row,int col){
        for (int i = 0; i < matrix.length ; i++) {
            matrix[i][col]=Integer.MIN_VALUE;
        }
        for (int i = 0; i < matrix[0].length ; i++) {
            matrix[row][i]=Integer.MIN_VALUE;
        }
    }

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
//                System.out.print(matrix[i][j]);
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int row:rows){
            for (int i = 0; i < matrix.length ; i++) {
                matrix[row][i]=0;
            }
        }

        for(int col:cols){
            for (int i = 0; i < matrix[0].length ; i++) {
                matrix[i][col]=0;
            }
        }
    }


    public static void main(String[] args) {
        int matrix[][] = {
                {1,1,1},{1,0,1},{1,1,1}};
        SetMatrixZeroes obj = new SetMatrixZeroes();
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        obj.setZeroes(matrix);
        System.out.println();
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
