//import java.util.ArrayList;
//import java.util.List;
//
//public class NQueen {
//    List<List<StringBuilder>> ans = new ArrayList<>();
//    public boolean isSafe(int n,ArrayList<StringBuilder> temp,int idx,int row){
//        for (int i = 0; i <row ; i++) {
//            if(temp.get(i).charAt(idx)=='Q'){
//                return false;
//            }
//        }
//        for (int i = 0; i <n ; i++) {
//            if (temp.get(row).charAt(i) =='Q') {
//                return false;
//            }
//        }
//        int i = row-1;
//        int j=idx-1;
//        int k=idx+1;
//        while (i>=0&&j>=0){
//            if (temp.get(i--).charAt(j--) == 'Q') {
//                return false;
//            }
//        }
//        i=row-1;
//        while (i>=0&&k<n){
//            if (temp.get(i--).charAt(k++) == 'Q') {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void halper(int n,ArrayList<StringBuilder> temp,int j){
//        if (j == n) {
//           ans.add(temp);
//            System.out.println(temp);
//           return;
//        }
//
//        for (int i = 0; i <n ; i++) {
//
//            if (isSafe(n,temp,i,j)) {
//                temp.get(j).setCharAt(i,'Q');
//                halper(n, temp, j+1);
//            }
//            temp.get(j).setCharAt(i,'.');
//            halper(n,temp,j+1);
//        }
//    }
//    public List<List<String>> solveNQueens(int n) {
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i <n ; i++) {
//            s.append('.');
//        }
//        String st = s.toString();
//        ArrayList<StringBuilder> temp = new ArrayList<>();
//        for (int i = 0; i <n ; i++) {
//            temp.add(new StringBuilder(st));
//        }
//        System.out.println(temp);
//        halper(n,temp,0);
//        List<List<String>> a = new ArrayList<>();
//        for (int i = 1; i < ans.size() ; i++) {
//           String t= ans.get(i).toString();
//            a.add(t);
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        NQueen n = new NQueen();
//        n.solveNQueens(4);
//    }
//}
