import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumFallingPathSumII {
     int minSum = Integer.MAX_VALUE;
    public void halper(int[][] grid,int i,int j,int sum,int prevCol,ArrayList<Integer> ans){
        if (minSum <sum) {
            return;
        }
        if (i== grid.length) {
            minSum = sum;
            System.out.println(ans+"  "+sum);
            return;
        }
        if (j == prevCol) {
            System.out.println("Hit");
            return;
        }
        for (int k = 0; k <grid.length ; k++) {

                ans.add(grid[i][j]);
                halper(grid,i+1,k,sum+grid[i][j],j,ans);
                ans.remove(ans.size()-1);


        }
    }


    public int minFallingPathSum(int[][] grid) {

        for (int i = 0; i <grid.length ; i++) {
            halper(grid,0,i,0,-1,new ArrayList<>());
        }

        return minSum;
    }


    public static void main(String[] args) {
        MinimumFallingPathSumII obj = new MinimumFallingPathSumII();
//        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] grid = {{-2,-18,31,-10,-71,82,47,56,-14,42},{-95,3,65,-7,64,75,-51,97,-66,-28},{36,3,-62,38,15,51,-58,-90,-23,-63},{58,-26,-42,-66,21,99,-94,-95,-90,89},{83,-66,-42,-45,43,85,51,-86,65,-39},{56,9,9,95,-56,-77,-2,20,78,17},{78,-13,-55,55,-7,43,-98,-89,38,90},{32,44,-47,81,-1,-55,-5,16,-81,17},{-87,82,2,86,-88,-58,-91,-79,44,-9},{-96,-14,-52,-8,12,38,84,77,-51,52}};
        obj.minFallingPathSum(grid);


    }
}
