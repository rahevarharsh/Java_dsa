public class Quee_usingLL {
    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        };
    }
    static class Quee{
       static Node head;
       static Node rear;
       Quee(){
           head=rear=null;
       }
       static void add(int data){
           Node n = new Node(data);
           if (head==null) {
               head=rear=n;
               return;
           }
           rear.next=n;
           rear = n;
       }
       static boolean isEmpty(){
           return head==null;
       }
       static int remove(){
           if (isEmpty()) {
               return -1;
           }
           int val = head.data;
           head = head.next;
           return val;
       }
       static int peek(){
           if(isEmpty()){
               return -1;
           }
           return head.data;
       }
    }

    public static void main(String[] args) {
        Quee q = new Quee();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);

        while (!q.isEmpty()){
            System.out.println(q.remove());
//            q.remove();
        }
    }
}
