public class BinaryString {
    public static boolean Isvalid(String s,int i){
        if (i == s.length()-1) {
            return true;
        }
        if(s.charAt(i)=='1'&& s.charAt(i+1)=='1'){
            return false;
        }
        return Isvalid(s,i+1);
    }
    public static void TotalString(int lastnum,int n,String s){
        if (n == 0) {
            System.out.println(s);
            return;
        }
        TotalString(0,n-1,s+'0');
        if (lastnum == 0) {
            TotalString(1,n-1,s+'1');
        }
    }
    public static void main(String[] args) {
//        System.out.println(Isvalid("101010011",0));
        TotalString(0,3,"");
    }

}
