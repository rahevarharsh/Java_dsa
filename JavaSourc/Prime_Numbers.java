import java.util.Scanner;

public class Prime_Numbers {
   public static boolean IsPrime(int n){
       if (n == 2) {
           return true;
       }
       for (int i = 2; i <= Math.sqrt(n) ; i++) {
           if (n%i==0) {
               return false;
           }
       }
       return true;
   }

   public static void Print_PrimeNumbers(int n){
       for (int i = 2; i <=n ; i++) {
           if(IsPrime(i)){
               System.out.print(i+" ");
           }
       }
   }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Print_PrimeNumbers(n);
    }
}
