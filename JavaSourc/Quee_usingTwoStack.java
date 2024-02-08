import java.util.Queue;
import java.util.Stack;

public class Quee_usingTwoStack {
    static class Quee{
       static Stack<Integer> s1 = new Stack<>();
       static Stack<Integer> s2 = new Stack<>();
        static void add(int data){
            s1.push(data);
        }
        static int remove(){
            if (s1.isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int data =s2.pop();
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return data;
        }
        static int peek(){
            if (s1.isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int data =s2.peek();
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return data;
        }

    }

    public static void main(String[] args) {
        Quee q = new Quee();
        q.add(1);
        q.add(2);
        q.remove();
        q.remove();
        System.out.println(q.peek());
    }
}
