public class Greedpath {
    public static int NumberOfways(int n,int m){
        if (n == 1 && m ==1) {
            return 1;
        }
        if (n == 0||m==0) {
            return 0;
        }
        return NumberOfways(n-1,m)+NumberOfways(n,m-1);
    }

    public static void main(String[] args) {
        System.out.println(NumberOfways(3,3))  ;
    }
}
