public class C1 {
    public int minLength(String s) {
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i <str.length()-1 ; i++) {
            if (str.charAt(i) == 'A'&&str.charAt(i+1)=='B') {
                str.delete(i,i+2);
                i=0;
            }
            else if (str.charAt(i) == 'C'&&str.charAt(i+1)=='D') {
                System.out.println(str);
                str.delete(i,i+2);
                i=0;
            }
        }
        for (int i = 0; i <str.length()-1 ; i++) {
            if (str.charAt(i) == 'A'&&str.charAt(i+1)=='B') {
                str.delete(i,i+2);
                i=0;
            }
            else if (str.charAt(i) == 'C'&&str.charAt(i+1)=='D') {
                System.out.println(str);
                str.delete(i,i+2);
                i=0;
            }
        }
        return str.length();
    }
    public static void main(String[] args) {
     C1 c = new C1() ;
        System.out.println(c.minLength("CCCCDDDD"));
    }
}
