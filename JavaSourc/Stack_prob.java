import java.util.ArrayList;
import java.util.Stack;

// class Node{
//    int data;
//    Node next;
//    Node(int data){
//        this.data = data;
//        this.next = null;
//    }
//}
//                          USING ARRAYLIST
public class Stack_prob {
//    public static class Stack{
//       static ArrayList<Integer> stck = new ArrayList<>();
//        public static boolean IsEmpty(){
//            return stck.size()==0;
//        }
//        public static void push(int data){
//            stck.add(data);
//        }
//        public static int peek(){
//            return stck.get(stck.size()-1);
//        }
//        public static int pop(){
//            int val = stck.get(stck.size()-1);
//            stck.remove(stck.size()-1);
//            return val;
//        }
//    }
//                                  USING LINKEDLIST
//public class Stack_prob {
//    public static class Stack{
//      public static Node head;
//      public static int size=0;
//      public boolean isEmpty(){
//          return head==null;
//      }
//      public void push(int data){
//          Node n = new Node(data);
//          size++;
//          if (head == null) {
//              head = n;
//              return;
//          }
//          n.next = head;
//          head = n;
//      }
//      public int peek(){
//          return isEmpty()? -1 :head.data;
//      }
//      public int pop(){
//          if (isEmpty()) {
//              return -1;
//          }
//          int val = head.data;
//          head = head.next;
//          return val;
//      }
//
//    }

    public static void addBottom(Stack<Integer> st,int data){
        if (st.isEmpty()) {
            st.add(data);
            return;
        }
        int val = st.pop();
        addBottom(st,data);
        st.add(val);
    }

    public static void ReverseStack(Stack<Integer> st){
        if (st.isEmpty()) {
            return;
        }
        int val = st.pop();
        ReverseStack(st);
        addBottom(st,val);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        System.out.println(st);
        st.add(10);
        st.add(20);
        st.add(30);
        System.out.println(st+"<- Top");
        ReverseStack(st);
        System.out.println(st+"<- Top");
    }
}
