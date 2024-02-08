public class StringtoInteger {

    public int myAtoi(String s) {
        s=s.trim();
        int idx = 0;
        int sign=1;
        if (s.equals("")) {
            return 0;
        }
        if (s.charAt(idx) == '-') {
            sign=-1;
            idx++;
        }
        else if (s.charAt(idx) == '+') {
            idx++;
        }
        Long ans=0l;
        while (idx<s.length() && Character.isDigit(s.charAt(idx))) {
            ans=ans*10+(s.charAt(idx)-'0');
            System.out.println(ans);
            if (ans >Integer.MAX_VALUE) {
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            idx++;
        }
        return (int)(sign*ans);
    }


    public static void main(String[] args) {
        String s = "";
        StringBuilder sb= new StringBuilder("");
       StringtoInteger obj = new StringtoInteger();
       ;
        System.out.println(obj.myAtoi(s));

    }

}
