public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (s.isEmpty()&&p.equals("*")) {
            return true;
        }
        if (s.charAt(0) == s.charAt(0)||s.charAt(0)=='.') {
            return isMatch(s.substring(1),p.substring(1));
        }
        else if (s.charAt(0)=='*') {
            return isMatch(s,p.substring(1))|| isMatch(s.substring(1),p.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        obj.isMatch("aaa","a");
    }
}
