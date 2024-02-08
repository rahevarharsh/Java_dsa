import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean Isprime = true;
        System.out.println("Enter Number :");
       do {
            int n = sc.nextInt();
            if (n == 2) {
                System.out.println(n + " is prime number ");
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        Isprime = false;
                    }
                }
                if (Isprime) {
                    System.out.println(n + " is Prime Number");
                } else {
                    System.out.println(n + " is Not Prime Number");
                }
            }
        }while (true);

    }
}
