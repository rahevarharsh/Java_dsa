import java.util.Stack;

public class ValidParentheses {

        public boolean halper(String s,Stack<Character> stack,int idx){
            if(idx==s.length()) return stack.empty();

            if(s.charAt(idx) == ']' ||s.charAt(idx) == ')'||s.charAt(idx) == '}'){
                if(stack.empty()||s.charAt(idx) == ']' && stack.peek()!='[' ||s.charAt(idx) == ')' && stack.peek()!='(' ||s.charAt(idx) == '}' && stack.peek()!='{') return false;
                else stack.pop();
            }
            else stack.push(s.charAt(idx));

            return halper(s,stack,idx+1);
        }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int idx = 0; idx <s.length() ; idx++) {
            if(s.charAt(idx) == ']' ||s.charAt(idx) == ')'||s.charAt(idx) == '}'){
                if(stack.empty()||s.charAt(idx) == ']' && stack.peek()!='[' ||s.charAt(idx) == ')' && stack.peek()!='(' ||s.charAt(idx) == '}' && stack.peek()!='{') return false;
                else stack.pop();
            }
            else stack.push(s.charAt(idx));
        }
        
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "[";
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid(s));
    }

}
