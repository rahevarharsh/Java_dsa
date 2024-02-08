public class Nqueen {
    public static void nqeenParmutation(char bord[][],int row){
        if (row == bord.length) {
            System.out.println("--------------------------------------");
            for (int i = 0; i < bord.length ; i++) {
                for (int j = 0; j < bord.length ; j++) {
                    System.out.print(bord[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i < bord.length ; i++) {
            bord[row][i] = 'Q';
            nqeenProblem(bord,row+1);
            bord[row][i] = 'X';
        }
    }

    public static boolean isSafe(char bord[][],int row,int col){
        for (int i = row; i >=0 ; i--) {
            if (bord[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row,j=col; i >=0&&j>=0 ; i--,j--) {
            if (bord[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row,j=col; i >=0&&j< bord.length ; i--,j++) {
            if (bord[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
static int count  = 0;
    public static void nqeenProblem(char bord[][],int row){
        if (row == bord.length) {
            count++;
            System.out.println("--------------------------------------");
            for (int i = 0; i < bord.length ; i++) {

                for (int j = 0; j < bord.length ; j++) {
                    System.out.print(bord[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i < bord.length ; i++) {
            if(isSafe(bord,row,i)) {
                bord[row][i] = 'Q';
                nqeenProblem(bord, row + 1);
                bord[row][i] = 'X';
            }
        }
    }
    public static void main(String[] args) {
        char bord[][] = new char[5][5];
        for (int i = 0; i < bord.length ; i++) {
            for (int j = 0; j < bord.length ; j++) {
                bord[i][j]='X';
            }
        }
        nqeenProblem(bord,0);
        System.out.println(count);
    }
}
