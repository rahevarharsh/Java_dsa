public class MergekSortedLists {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    static ListNode head = null;
    public ListNode mergeKLists(ListNode[] lists) {
        int array[] = new int[20000];
        for(ListNode n:lists){
            while (n!=null){
                array[10000+n.val]++;
                n= n.next;
            }
        }

        ListNode ret = null;
        ListNode temp = null;
        boolean retHead = false;
        System.out.println();
        for (int i = 0; i <array.length ; i++) {
//            System.out.print(" ( "+i+" , "+array[i]+" ) ");
            if (array[i] != 0) {
                while (array[i] != 0){
//                    System.out.print(i-10000+" ");
                    array[i]--;
                    ListNode newNode = new ListNode(i-10000,null);
                    if (!retHead) {
                        retHead = true;
                        ret = newNode;
                        temp = ret;
//                        head = ret;
                    }
                    else{
                        ret.next = newNode;
                        ret = ret.next;
                    }

//                    System.out.println("IN");
                }
            }
        }

        return temp;
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode reHead = head;
//        ListNode p1 = head;
//        ListNode p2 = head;
//        for (int i = 1; i <k ; i++) {
//            p2=p2.next;
//        }
//        while (p2!=null){
//
//        }
//    }


    public static void main(String[] args) {
        MergekSortedLists obj =new MergekSortedLists();
        ListNode n1 = new ListNode(1,null);
        ListNode temp = n1;
        temp.next = new ListNode(4,new ListNode(5,null));
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp =temp.next;
       }
        ListNode n2 = new ListNode(1,new ListNode(3,new ListNode(4,null)));
        ListNode temp2 = n2;
        System.out.println();
        while (temp2!=null){
            System.out.print(temp2.val+" ");
            temp2 =temp2.next;
        }
        ListNode n3 = new ListNode(2,new ListNode(6,null));
        ListNode temp3 = n3;
        System.out.println();
        while (temp3!=null){
            System.out.print(temp3.val+" ");
            temp3 =temp3.next;
        }
        ListNode []ls = {n1,n2,n3};
        obj.mergeKLists(ls);
    }
}
