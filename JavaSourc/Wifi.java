import java.util.Scanner;

public class Wifi {
    public static void main(String[] args) {
        String s = "12345678";
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();

        if (s1.equals(s)) {
            System.out.println("conneted");
        }
        else{
            System.out.println("Worng password");
        }

    }
}
