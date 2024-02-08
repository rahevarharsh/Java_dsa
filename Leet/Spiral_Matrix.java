//import java.util.ArrayList;
//import java.util.List;
//
//public class Spiral_Matrix {
//    List<Integer> ans = new ArrayList<>();
//    void halper(int[][] matrix,int frow,int erow,int fcol,int ecol){
//        for (int i = fcol; i <=ecol ; i++) {
//            ans.add(matrix[frow][i]);
//        }
//
//        for (int i = frow+1; i <=erow ; i++) {
//            ans.add(matrix[i][ecol]);
//        }
//        for (int i = ecol-1; i >=fcol ; i--) {
//            ans.add(matrix[erow][i]);
//        }
//
//        for (int i = erow-1; i >frow ; i--) {
//            ans.add(matrix[i][fcol]);
//        }
//
//    }
//    public List<Integer> spiralOrder(int[][] matrix) {
//        halper(matrix,0,matrix);
//    }
//    public static void main(String[] args) {
//        int arr[][] =  {{1,2,3},{4,5,6},{7,8,9}};
//    }
//}
