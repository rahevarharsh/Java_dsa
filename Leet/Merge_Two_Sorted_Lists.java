public class Merge_Two_Sorted_Lists {

    public static class Node{
        int data;
        LinkList.Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static LinkList.Node head;
    public static LinkList.Node tail;
    public static int size =0;
    public void addFirst(int data){
        LinkList.Node n = new LinkList.Node(data);
        size++;
        if(head==null){
            tail= head = n;
            return;
        }
        n.next = head;
        head = n;
    }

    public void addLast(int data){
        LinkList.Node n = new LinkList.Node(data);
        size++;
        if (head == null) {
            tail = head = n;
            return;
        }
        tail.next = n;
        tail = n;
    }

    public void printLinkedList(){
        LinkList.Node temp = head;
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
        LinkList.Node prev = head;
        for (int i = 0; i <idx-1 ; i++) {
            prev=prev.next;
        }
        LinkList.Node n = new LinkList.Node(data);
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
        LinkList.Node prev = head;
        LinkList.Node temp = prev.next;
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
        LinkList.Node temp = head;
        for (int i = 0; i <size-2 ; i++) {
            temp = temp.next;
        }
        size--;
        int val = tail.data;
        temp.next = null;
        tail = temp;
        return val;
    }


    public static void main(String[] args) {


    }
}
