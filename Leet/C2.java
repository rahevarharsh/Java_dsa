public class C2 {



    public String makeSmallestPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        int j = str.length()-1;
        while (i<=j) {
            if (str.charAt(i) < str.charAt(j)) {
                str.setCharAt (j, str.charAt(i));
            }
            else if(str.charAt(i) > str.charAt(j)) {
                str.setCharAt (i, str.charAt(j));
            }
            i++;
            j--;
        }
        s = str.toString();
        return s;
    }

    public static void main(String[] args) {
        C2 c = new C2();
        System.out.println(c.makeSmallestPalindrome("abcd"));
    }
}
