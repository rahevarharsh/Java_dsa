public class Tries {
   static class Node {
       Node alph[]= new Node[26];
       Boolean eow = false;


       Node(){
           for (int i = 0; i <alph.length ; i++) {
               alph[i]=null;
           }
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

    public static void main(String[] args) {
        String words[] = {"i","like","sam","samsung","mobile","ice"};

        Tries obj = new Tries();
       for(String s:words){
           obj.Insert(s);
       }
//        for(String s:words){
//            System.out.println(obj.Search(s));
//        }
//        System.out.println( obj.Search("ther"));
        System.out.println(obj.WordBreak("ilikesammobile"));
    }
}
