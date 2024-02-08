public class Wildcard_Matching {
    public boolean halper(String s,String p,int is,int ip){
        if (is>=s.length()&&ip>=p.length()) {
            return true;
        }
        else if (is>=s.length()||ip>=p.length()) {
            System.out.println(is+" "+ip);
            return false;
        }
        int index_s = is;
        int index_p = ip;
        if (p.charAt(ip) == '?'||p.charAt(ip) == s.charAt(is)) {
//          return   halper(s,p,is+1,ip+1);
            index_s++;
            index_p++;
        }
        else  if (p.charAt(index_p) == '*') {
            int i = is;
            while (is+1<s.length()&&s.charAt(is)==s.charAt(is+1)){
                is++;
            }
            index_s = is+1;
            index_p++;
//            return halper(s,p,i,ip+1);
        }
        else  if (p.charAt(ip) != s.charAt(is)) {
            return false;
        }
        return halper(s,p,index_s,index_p);
    }

    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        return halper(s,p,0,0);
    }

    public static void main(String[] args) {
        Wildcard_Matching obj = new Wildcard_Matching();
        System.out.println(obj.isMatch("aaaaaaaaa","*a"));
    }
}
