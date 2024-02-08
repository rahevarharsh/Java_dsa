import java.util.ArrayList;
import java.util.List;

public class Find_the_Substring_With_Maximum_Cost {
    ArrayList<String> al = new ArrayList<>();
     void  subMaker(String s,int idx,String temp){
        if (s.length()==idx){
            al.add(temp);
            System.out.println(temp);
            return;
        }

         for (int i = idx; i <s.length() ; i++) {
             subMaker(s,idx+1,temp+s.charAt(idx));
         }
    }

    public  int maximumCostSubstring(String s, String chars, int[] vals) {
        subMaker(s,0,"");
        int alph[] = new int[26];
        for (char i = 'a'; i <='z' ; i++) {
            for (int j = 0; j <chars.length() ; j++) {
                if (chars.charAt(j) == i) {
                    alph['a'-i] = vals[j];
                    continue;
                }
            }
            alph['a'-i]=1;
        }
       int cost = Integer.MIN_VALUE;
        for (int i = 0; i < al.size() ; i++) {
            String sub = al.get(i);
           int tempcost = 0;
            for (int j = 0; j <sub.length() ; j++) {
                tempcost+=alph[sub.charAt(j)-'a'];
            }
            cost = Integer.max(cost,tempcost);
        }
        return cost;
    }

    public static void main(String[] args) {
    Find_the_Substring_With_Maximum_Cost ft = new Find_the_Substring_With_Maximum_Cost();
    ft.subMaker("abaa",0,"");
        System.out.println(ft.al);
    }
}
