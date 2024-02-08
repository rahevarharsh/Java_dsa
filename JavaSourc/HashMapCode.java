import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {

    static class HashMap<K,V>{
        private class Node{
            K key;
            V val;
            Node(K key,V val){
                this.key = key;
                this.val =val;
            }
        }

        private int n ;
        private int N ;
        private LinkedList<Node> buckets[];
        HashMap(){
            n=0;
            N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i <N ; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public int findBucketIndex(K key){
            int idx = key.hashCode();
            return Math.abs(idx)%N;
        }

        public int findInLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i <ll.size() ; i++) {
                if(ll.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }

        public void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            LinkedList<Node> buckets[] = new LinkedList[2*N];
            N = N*2;
            for (int i = 0; i < oldBucket.length ; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j <ll.size() ; j++) {
                    put(ll.get(j).key,ll.get(j).val);
                }
            }
        }

        public void put(K key,V val){
            int bi = findBucketIndex(key);
            int li = findInLL(key,bi);
            if (li != -1) {
               Node node = buckets[bi].get(li);
               node.val = val;
            }
            else{
                LinkedList<Node> ll = buckets[bi];
                ll.add(new Node(key,val));
                n++;
            }
            if (n/N>2) {
                rehash();
            }
        }

        public V remove(K key){
            int bi = findBucketIndex(key);
            int li = findInLL(key,bi);
            if (li != -1) {
                Node node = buckets[bi].remove(li);
                n--;
                return node.val;
            }
            else{
              return null;
            }
        }

        public V get(K key){
            int bi = findBucketIndex(key);
            int li = findInLL(key,bi);
            if (li != -1) {
                Node node = buckets[bi].get(li);
                return node.val;
            }
            else{
                return null;
            }
        }

        public ArrayList<K> keyset(){
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < N ; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size() ; j++) {
                    keys.add(ll.get(j).key);
                }
            }
            return keys;
        }

    }

    public static void main(String[] args) {

        HashMap<String,Integer> test = new HashMap<>();
        test.put("Harsh",1079);
        test.put("Lav",1082);
        test.put("Shanu",1026);
        test.put("Cronin",1020);
        System.out.println(test.get("Cronin"));
    }
}
