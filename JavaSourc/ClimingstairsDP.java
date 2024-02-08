import java.util.Arrays;

public class ClimingstairsDP {

    public int climingstair(int dp[],int n){
        if (n == 0) return 1;
        if (n<0) return 0;
        if (dp[n]!=-1 ) {
            return dp[n];
        }
        return dp[n] = climingstair(dp, n-1)+climingstair(dp, n-2);
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        ClimingstairsDP obj = new ClimingstairsDP();
        System.out.println(obj.climingstair(dp,n));
    }
}
