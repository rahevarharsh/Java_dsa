public class PowXN {


    public double PowMul(double x, int n){
        if (n == 0) return 1;

        if (n==1) return x;
        double ans = PowMul(x,n/2);
        if (n%2==0) return ans * ans;
        else return ans*ans*x;
    }


    public double myPow(double x, int n) {
        if (n==0) {
            return 1;
        }
        double ans = PowMul(x,n);
        if (n>0) {
           return ans;
        }
        return (1/ans);

    }

    public static void main(String[] args) {
        PowXN obj =new PowXN();
        System.out.println(obj.myPow(2.1,-7));
    }
}
