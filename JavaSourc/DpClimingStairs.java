public class DpClimingStairs {

    public int Climingstairs(int n,int dp[]){
        if(n==0||n==1){
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = Climingstairs(n-1,dp)+Climingstairs(n-2,dp);
    }

    public int ClimigstairsTabulation(int n){
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DpClimingStairs obj = new DpClimingStairs();
        int n=5;
        int dp[] = new int[n+1];
        System.out.println(obj.Climingstairs(n,dp));
        System.out.println(obj.ClimigstairsTabulation(n));
    }
}
