import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args){

//        System.out.println(numlist);
//        System.out.println(str);
        StringBuilder s = new StringBuilder("");
//        makeMap();
        Solution soul = new Solution();
       List<String> sl= soul.letterCombinations("9");
        System.out.println(sl);

    }
}

class Solution {
    static ArrayList<ArrayList<Character>> str = new ArrayList<>();
    public static void NumberList() {
        int count = 0;
        ArrayList<Character> al = new ArrayList<>();
        for (char i = 'a'; i <='o' ; i++) {
            if (count %3 == 0) {
                str.add(al);
                al = new ArrayList<>();
            }
            al.add(i);
            count++;
        }
        str.add(al);
        al = new ArrayList<>();
        al.add('p');
        al.add('q');
        al.add('r');
        al.add('s');
        str.add(al);
        al = new ArrayList<>();
        al.add('t');
        al.add('u');
        al.add('v');
        str.add(al);
        al = new ArrayList<>();
        al.add('w');
        al.add('x');
        al.add('y');
        al.add('z');
        str.add(al);
        str.remove(0);
    }
    static Map<Character,ArrayList<Character>> numlist = new HashMap<>();
    public static void makeMap(){
        NumberList();
        for (char i = '2'; i <= '9' ; i++) {
            numlist.put(i, str.get(i-'2'));
        }
    }

    static List<String> sl= new ArrayList<String>();
    public static void halper(String digits,int idx,String s){
        if (digits.length() == idx) {
            sl.add(s);
            return;
        }
        ArrayList<Character> alph= numlist.get(digits.charAt(idx));

        for (int i = 0; i < alph.size() ; i++) {
            halper(digits,idx+1,s+(alph.get(i)));
        }

    }

    public List<String> letterCombinations(String digits) {
        makeMap();
        halper(digits,0,"");
        return sl;
    }
}