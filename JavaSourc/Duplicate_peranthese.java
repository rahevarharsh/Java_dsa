import java.util.Stack;

public class Duplicate_peranthese {
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i)==')') {
                int count =0;
                while (!s.isEmpty()&&s.peek()!='('){
                    count++;
                    s.pop();
                }
                if (count == 0) {return true;}
                else{s.pop();}
            }
            else{
                s.push(str.charAt(i));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(((a+b)+(b)))";
        System.out.println(isDuplicate(str));
    }
}
