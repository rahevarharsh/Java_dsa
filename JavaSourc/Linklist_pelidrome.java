public class Linklist_pelidrome {
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
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
        System.out.println();
    }

    public static Node getMidle(){
        Node slow = head;
        Node fast = head;
        while(slow!=null &&fast!=null &&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean Isplidrom(){
        Node mid = getMidle();
        Node prev = null;
        Node curr = mid;
        Node nxt ;
        while (curr!=null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        Node rhead = prev;
        Node fhead = head;
        while (rhead!=null&&fhead!=null){
            if (rhead.data !=fhead.data ) {
                return false;
            }
            rhead = rhead.next;
            fhead = fhead.next;
        }
        return true;
    }

    public static void main(String[] args) {
    Linklist_pelidrome lp = new Linklist_pelidrome();
lp.addLast(2);
        lp.addLast(1);
        lp.addLast(1);
        lp.addLast(1);
        lp.addLast(2);

        lp.printLinkedList();
        System.out.println(lp.Isplidrom());
    }
}
