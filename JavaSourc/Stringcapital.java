import java.util.Scanner;

public class Stringcapital {

    public static String applyOn(String s){
        StringBuilder str = new StringBuilder("");
        str.append(Character.toUpperCase(s.charAt(0)));
        for (int i = 1; i < s.length() ; i++) {
            if ((s.charAt(i)==' ')&& (i<s.length()-1)) {
                str.append(s.charAt(i));
                i++;
                str.append(Character.toUpperCase(s.charAt(i)));
                i++;
            }
            str.append(s.charAt(i));
        }
        System.out.println(str);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "hello world this is for on";
        applyOn(str);
    }
}
