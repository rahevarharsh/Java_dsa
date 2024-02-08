public class LinkList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size =0;
    public void addFirst(int data){
        Node n = new Node(data);
        size++;
        if(head==null){
            tail= head = n;
            return;
        }
        n.next = head;
        head = n;
    }

    public void addLast(int data){
        Node n = new Node(data);
        size++;
        if (head == null) {
            tail = head = n;
            return;
        }
        tail.next = n;
        tail = n;
    }

    public void printLinkedList(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
    }

    public void  addAtIndex(int data,int idx){
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node prev = head;
        for (int i = 0; i <idx-1 ; i++) {
            prev=prev.next;
        }
        Node n = new Node(data);
        n.next = prev.next;
        prev.next = n;
        size++;
    }

    public static int removeFirst(){
        if (head == null) {
            System.out.println("Empty LL");
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head =  head.next;
        size--;
        return val;
    }

    public void removElement(int el){
        Node prev = head;
        Node temp = prev.next;
        while (temp.data!=el){
            prev = prev.next;
            temp = temp.next;
        }
        prev.next = temp.next;
    }

    public int removeLast(){
        if (head == null) {
            System.out.println("Empty LL");
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node temp = head;
        for (int i = 0; i <size-2 ; i++) {
            temp = temp.next;
        }
        size--;
        int val = tail.data;
        temp.next = null;
        tail = temp;
        return val;
    }

    public static int removeAtIndex(int idx){
        if (idx == 0) {
            return removeFirst();
        }
        Node temp = head;
        for (int i = 0; i <idx-1 ; i++) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;
    }

    public void ReversLL(){
        Node prev = null;
        Node curr =tail =  head;
        Node next ;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return;
    }

    public static void main(String[] args) {
      LinkList li = new LinkList();
      li.addFirst(1);
        li.addFirst(2);
        li.addFirst(3);
        li.addFirst(4);
        li.addAtIndex(100,2);
        li.addLast(14);
        li.addAtIndex(11,size);
        System.out.println(tail.data);
        li.printLinkedList();
//        li.removeFirst();
//        li.removeLast() ;
//        li.removeAtIndex(0);
        System.out.println();
        li.ReversLL();
        li.removElement(100);
        li.printLinkedList();
//        System.out.println(size);
//        Math.pow();
    }
}
