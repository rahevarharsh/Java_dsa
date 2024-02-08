import java.util.Stack;

public class Valid_Parentheses {

    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == '{'||s.charAt(i) == '('||s.charAt(i) == '[') {
                stk.push(s.charAt(i));
            }
            else{
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

    public static void main(String[] args) {

        System.out.println(isValid("()[]{}"));
    }
}
