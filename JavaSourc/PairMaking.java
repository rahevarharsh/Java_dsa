public class PairMaking {
    public static int pairOfparson(int n){
        if (n == 1||n==2) {
            return n;
        }
        return pairOfparson(n-1)+(n-1)*pairOfparson(n-2);
    }

    public static void main(String[] args) {
        System.out.println(pairOfparson(3));
    }
}
