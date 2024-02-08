import java.util.ArrayList;
import java.util.Collections;

public class PrefixProblem {
    static class Node {
        Node alph[]= new Node[26];
        Boolean eow = false;
        int NoNode;


        Node(){
            for (int i = 0; i <alph.length ; i++) {
                alph[i]=null;
            }
            NoNode = 0;
        }
    }

    static Node root = new Node();
    public void Insert(String s){
        Node curr = root;
        for (int i = 0; i <s.length() ; i++) {
            int idx = s.charAt(i)-'a';
            if (curr.alph[idx]==null) {
                curr.alph[idx]=new Node();
            }
            curr.NoNode++;
            curr = curr.alph[idx];
        }
        curr.eow = true;
    }

    public boolean Search(String s){
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int  idx = s.charAt(i)-'a';
            if (curr.alph[idx]==null) {
                return false;
            }
            curr = curr.alph[idx];
        }
        return curr.eow;
    }


    public int halper(String s){
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int  idx = s.charAt(i)-'a';
            if (curr.alph[idx] == null) {
                return -1;
            }
            if (curr.NoNode == 1) {
                return i;
            }
            curr = curr.alph[idx];
        }
        return s.length();
    }

    public boolean WordBreak(String s){
        if (s.equals("")) {
            return true;
        }
        for (int i = 1; i <=s.length() ; i++) {
            String sub = s.substring(0,i);
            if (Search(sub)) {
                if (WordBreak(s.substring(i))) {
                    return true;
                }
            }
        }
        return false;

    }

    public ArrayList<String> prefix(String arr[]){
        StringBuilder temp = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < arr.length ; i++) {
            int end = halper(arr[i]);
            ans.add(arr[i].substring(0,end));
        }
        return ans;
    }


    public boolean isStartWith(String s){
        return halper(s)!=-1;
    }


    public int countNode(Node curr){
        if (curr == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <26 ; i++) {
            if (curr.alph[i]!=null) {
               count+= countNode(curr.alph[i])+1;
            }
        }
        return count;
    }

    public int UniqSubString(String s){
        for (int i = 0; i <s.length() ; i++) {
            String str = s.substring(i);
            Insert(str);
        }
        return countNode(root)+1;
    }

    public boolean Isprefix(String s){
        Node curr = root;

        for (int i = 0; i <s.length() ; i++) {
            int idx = s.charAt(i)-'a';
            if (curr.alph[idx]==null) {
                System.out.println(1);
                return false;
            }
            curr=curr.alph[idx];
            if (!curr.eow) {
                System.out.println(2);
                return false;
            }
        }
        for (int i = 0; i <26 ; i++) {
            if (curr.alph[i]!=null) {
                return false;
            }
        }
        return curr.eow;
    }

    public String LongestWord(String[] words){
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < words.length ; i++) {
            if (Isprefix(words[i])) {
                options.add(words[i]);
            }
        }
        Collections.sort(options);
        System.out.println(options);
        return options.get(0);
    }
    public String ans = "";
    public void getArray(Node curr,String temp){
        if (curr == null) {
            return;
        }
        System.out.println(temp+" "+ans);
        for (int i = 0; i <26 ; i++) {
            if (curr.alph[i] != null&& curr.eow==true) {
                getArray(curr.alph[i], temp+(char)('a'+i));
            }
        }
        if (ans.length()>temp.length()) {
            return;
        }
        else if (ans.length()==temp.length()) {
            ans=ans.compareTo(temp)<0?temp:ans;
            return;
        }
        ans = temp;
        return;

    }

    public String temp = "";
    public String LongestWord2(Node curr,StringBuilder ans,int idx){
        if (curr == null) {
            return "";
        }
        for (int i = 0; i <26 ; i++) {
            if (curr.alph[i]!=null&&curr.alph[i].eow) {
               ans.append((char)('a'+i));
                if (temp.length()<ans.length()) {
                    temp = new String(ans.toString()) ;
                }
                LongestWord2(curr.alph[i], ans,idx+1);
                ans.deleteCharAt(ans.length()-1);
            }
        }

//        else if (temp.length()==ans.length()) {
//            temp = temp.compareTo(ans)<0?temp:ans;
//        }
        return temp;
    }

    public static void main(String[] args) {
//        String words[] = {"i","l","li","lik","like","sam","samsung","mobile","ice"};
//        String words[] = {"aab","acd","mba","iit","iim"};
        PrefixProblem obj = new PrefixProblem();
//        for(String s:words){
//            obj.Insert(s);
//        }
//        System.out.println(obj.prefix(words));
//        System.out.println(obj.isStartWith("mb"));

//        System.out.println(obj.UniqSubString("ababa"));
//        String s1 = "apple";
//        String s2 = "apply";
//        System.out.println(s2.compareTo(s1));


        String words[] = {"a","banana","app","appl","ap","apply","apple"};
        for(String s:words){
            obj.Insert(s);
        }

//        System.out.println(obj.LongestWord(words));
//        obj.getArray(root,"");
//        System.out.println("A".compareTo("Z"));
        System.out.println( obj.LongestWord2(root,new StringBuilder(""),0));
//        System.out.println(obj.temp);
    }
}
