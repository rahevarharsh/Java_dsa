import java.util.Scanner;

public class Decimal_2_Binary {
    public static void Convert_D_2_B(int n){
        int p = 0;
        int bin = 0;
        while (n>0){
            int remainder = n%2;
            bin=bin+remainder*(int)Math.pow(10,p);
            p++;
            n = n/2;
        }
        System.out.println(bin);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        Convert_D_2_B(24);
    }
}
