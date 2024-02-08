import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Generate_Parentheses {
   static List<String> gps = new ArrayList<>();


    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == '{'||s.charAt(i) == '('||s.charAt(i) == '[') {
                stk.push(s.charAt(i));
            }
            else{
                if (stk.isEmpty()) {
                    return false;
                }
                if (s.charAt(i) == ']'&& stk.peek()!='[') {
                    return false;
                }
                else if (s.charAt(i) == '}'&& stk.peek()!='{') {
                    return false;
                }
                else if (s.charAt(i) == ')'&& stk.peek()!='(') {
                    return false;
                }
                stk.pop();
            }
        }
        if (!stk.isEmpty()) {
            return false;
        }
        return true;
    }


   public static void halper(int n,String temp,int idx){
       if (idx == n) {
           if (temp.charAt(0)=='('&&isValid(temp)) {
               gps.add(temp) ;
           }

           return;

       }
       halper(n,temp+'(',idx+1);
       halper(n,temp+')',idx+1);
   }
    public static List<String> generateParenthesis(int n) {
        halper(2*n,"",0);
        return gps;
    }

    public static void main(String[] args) {
        generateParenthesis(1);
        System.out.println(gps);
    }
}
