import java.util.Scanner;

public class N_C_R {

    public static int factorial(int n){
        if (n == 1 || n == 0) {
            return 1;
        }
        return factorial(n-1)*n;
    }

    public static void combination(int n,int r){
        System.out.println(factorial(n)/(factorial(r)*factorial(n-r)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        combination(n,r);
    }
}
