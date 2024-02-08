import java.util.ArrayDeque;
import java.util.Queue;

public class Interleave {
    public static void interleave(Queue<Integer> q){
        int mid = q.size()/2;
        Queue<Integer> q2 = new ArrayDeque<>();
        for (int i = 0; i <mid ; i++) {
            q2.add(q.remove());
        }
        while (!q2.isEmpty()){
            q.add(q2.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.println(q);
        interleave(q);
        System.out.println(q);
    }
}
