import java.util.TreeMap;

public class Anagram {
    public boolean IsAnagram(String s1,String s2){
        TreeMap<Character,Integer> str1 = new TreeMap<>();
        TreeMap<Character,Integer> str2 = new TreeMap<>();

        for (int i = 0; i <s1.length() ; i++) {
            if (str1.containsKey(s1.charAt(i))) {
                str1.put(s1.charAt(i),str1.get(s1.charAt(i))+1);
            }
            else{
                str1.put(s1.charAt(i),1);
            }
        }
        for (int i = 0; i <s2.length() ; i++) {
            if (str2.containsKey(s2.charAt(i))) {
                str2.put(s2.charAt(i),str2.get(s2.charAt(i))+1);
            }
            else{
                str2.put(s2.charAt(i),1);
            }
        }
//        System.out.println(str1);
//        System.out.println(str2);
//        System.out.println();
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        Anagram obj = new Anagram();


        System.out.println(obj.IsAnagram("tulip","tulipz"));
    }
}
