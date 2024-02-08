public class Add_Two_Numbers {
    public static class ListNode {
    int val;
     ListNode next;
    ListNode() {}
        ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    ListNode l;
    void halper(ListNode l1,ListNode l2){
        int carry=0;
        ListNode ptr = l=null;
        while(l1!=null||l2!=null){
            if(ptr==null){
                int sum = l1.val+l2.val;
                if(sum>9){
                    sum =sum-10;
                    carry++;
                }
                ptr=l = new ListNode(sum);
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }

            if(l1==null){
                System.out.println("IN l1 == null");
                while(l2!=null){
                    int sum = l2.val+carry;
                    if(carry==0){
                        if(sum>9){
                            sum = sum-10;
                            carry++;
                        }
                        ptr.next = new ListNode(sum);
                        ptr = ptr.next;
                        l2 = l2.next;
                    }
                    else{
                        carry--;
                        if(sum>9){
                            sum = sum-10;
                            carry++;
                        }
                        ptr.next = new ListNode(sum);
                        ptr = ptr.next;
                        l2 = l2.next;
                    }
                }
            }
            else if(l2==null){
                System.out.println("IN l2 == null");
                while(l1!=null){
                    int sum = l1.val+carry;
                    if(carry==0){
                        if(sum>9){
                            sum = sum-10;
                            carry++;
                        }
                        ptr.next = new ListNode(sum);
                        ptr = ptr.next;
                        l1 = l1.next;
                    }
                    else{
                        carry--;
                        if(sum>9){
                            sum = sum-10;
                            carry++;
                        }
                        ptr.next = new ListNode(sum);
                        ptr = ptr.next;
                        l1 = l1.next;
                    }
                }
            }
            else{
                 int sum = l1.val+ l2.val+carry;
                 if (carry==0&&sum>9){
                     carry++;
                 }
                 else if (carry==1&&sum<10) {
                     carry--;
                 }
                if (sum > 9) {
                    sum = sum-10;
                }
                ptr.next = new ListNode(sum);
                ptr = ptr.next;
                l1 = l1.next;
                l2 = l2.next;
            }

        }
        if (carry == 1) {
            ptr.next = new ListNode(carry);
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        halper(l1,l2);
        return l;
    }

    public static void main(String[] args) {
//        int arr1[] ={4,3};
//        int arr2[] = {6,4};
        ListNode l1head = new ListNode(0),ptr1;
        ListNode l2head = new ListNode(0),ptr2;
        ptr1 = l1head;
        ptr2 = l2head;

//        for(int d:arr1){
//        ptr1.next = new ListNode(d);
//        ptr1 = ptr1.next;
//        }
//
//        for(int d:arr2){
//            ptr2.next = new ListNode(d);
//            ptr2 = ptr2.next;
//        }
        Add_Two_Numbers atn = new Add_Two_Numbers();
        atn.addTwoNumbers(l1head,l2head);
       while (atn.l !=null){
           System.out.print(atn.l.val+" --> ");
           atn.l =atn.l.next;
       }
    }
}
