import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum  {

    static class Pair implements Comparable<Pair>{
        int idx;
        int val;
        Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
        @Override
        public int compareTo(Pair o) {
            return o.val-this.val;
        }

    }
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k=3;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i <k ; i++) {
            pq.add(new Pair(i,arr[i]));
        }
        System.out.println(pq);
        ArrayList<Integer> al = new ArrayList<>();
        al.add(pq.peek().val);
        al.add(pq.peek().val);
        for (int i = k; i <arr.length ; i++) {
            while (pq.peek().idx<i-k){
                pq.remove();
            }
            pq.add(new Pair(i,arr[i]));
            al.add(pq.peek().val);
        }
        System.out.println(al);
    }
}
