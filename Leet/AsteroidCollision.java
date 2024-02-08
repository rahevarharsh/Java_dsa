import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class AsteroidCollision {

    static class info implements Comparable<info>{
        int value;
        boolean positive;
        int idx;
        info(int value,boolean positive,int idx){
            this.value = value;
            this.positive = positive;
            this.idx = idx;
        }

        @Override
        public int compareTo(info o) {
            return o.value-this.value;
        }
    }

    static class element implements Comparable<element>{
        int val;
        int idx;
        element(int idx,int val){
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(element o) {
            return this.idx-o.idx;
        }
    }

    public int[] asteroidCollision(int[] asteroids) {

        Stack<info> stack = new Stack<>();
        stack.add(new info(Math.abs(asteroids[asteroids.length-1]),asteroids[asteroids.length-1]>0?true:false,asteroids.length-1));
        for (int i = asteroids.length-2; i >=0 ; i--) {
            info curr = stack.peek();

            int ast = asteroids[i];
            boolean astPositive = ast>0?true:false;
            if (curr == null) {
                stack.add(new info(ast,astPositive,i));
                continue;
            }
            if (astPositive == curr.positive) {
                stack.add(new info(ast,astPositive,i));
                continue;
            }
            else if (astPositive!=curr.positive) {
                if (ast == curr.value) {
                    stack.pop();
                }
                else if (ast > curr.value) {
                    stack.pop();
                    stack.add(new info(ast,astPositive,i));
                }
            }

        }
        ArrayList<element> al = new ArrayList<>();
        while (!stack.isEmpty()){
            info c = stack.pop();
            al.add(new element(c.idx,c.value));
//            System.out.print(c.value+" "+c.positive+" "+c.idx+" --> ");
        }
        asteroids= new int[al.size()];
        Collections.sort(al);
        int idx=0;
        for(element e:al){
            asteroids[idx++] = e.val;
        }
        return asteroids;

    }

    public static void main(String[] args) {
        int arr[]={-2,-1,1,2};
        AsteroidCollision obj = new AsteroidCollision();
       int num[] = obj.asteroidCollision(arr);
        System.out.println();
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }
    }
}
