import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    static class Node{
        boolean eow;
        Node arr[];
        Node()
        {
            eow = false;
            arr= new Node[26];
            for(int i=0;i<26;i++){
                arr[i]=null;
            }
        }
    }
    Node root = new Node();

    public void AddWords(String s){
        Node curr = root;
        for (int i = 0; i <s.length() ; i++) {
            int idx = s.charAt(i)-'a';
            if (curr.arr[idx]==null) {
                curr.arr[idx]=new Node();
            }
            curr=curr.arr[idx];
        }
        curr.eow = true;
    }

    public boolean Search(String s){
        Node curr = root;
        for (int i = 0; i <s.length() ; i++) {
            int idx = s.charAt(i)-'a';
            if (curr.arr[idx]==null) {
                return false;
            }
            curr=curr.arr[idx];
        }
        return curr.eow;
    }

    public boolean halper(String s){
        if (s.equals("")) {
            return true;
        }

        for (int i = 1; i <=s.length() ; i++) {
            String str = s.substring(0,i);
            if (Search(str)) {
                if (halper(s.substring(i))) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str:wordDict){
            AddWords(str);
        }
       return halper( s);
    }

    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        String arr[] = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        for (String s:arr) {
            str.add(s);
        }
//        str.add("aaaa");
//        str.add("aaa");
        WordBreak obj =new WordBreak();
        System.out.println(obj.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",str));

//        for (String s:str) {
//            System.out.println(obj.Search(s));
//        }
    }
}
