import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class FirstNonRepeated {

    public static void firstNonreapeated(String s){
        int []freq = new int[26];
        Queue<Character> qu = new ArrayDeque<>();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            freq[c-'a']++;
            qu.add(c);
            while (!qu.isEmpty()&&freq[qu.peek()-'a']>1){
                qu.remove();
            }
            if (qu.isEmpty()) {
                System.out.print(-1+" ");
            }
            else{
                System.out.print(qu.peek()+" ");
            }
        }

    }

    public static void main(String[] args) {
        firstNonreapeated("aabbccxb");
    }

}
