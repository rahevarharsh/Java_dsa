import java.util.*;

public class SubstringwithConcatenation {

    ArrayList<String> prem = new ArrayList<>();
    public void premutataion(String []arr,int i){
        if (arr.length == i) {
            StringBuilder temp = new StringBuilder("");
            for(String d:arr){
                temp.append(d);
            }
            prem.add(temp.toString());
            return;
        }
        for (int j = i; j < arr.length ; j++) {
            String t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            premutataion(arr, i+1);
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        premutataion(words,0);
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int idx;
        for(String str:prem){
            System.out.println();
            idx = s.indexOf(str);
            if (idx!=-1) {
                set.add(idx);
                int counter =1;
                String temp = s.substring(idx+1);
                while (temp.indexOf(str)!=-1){
                    System.out.println(temp);
                    System.out.println(temp.indexOf(s));
                }
            }

        }
        for(int d:set){
            ans.add(d);
        }
        return ans;
    }

    public static void main(String[] args) {
        String arr[] = {"foo","bar"};
        SubstringwithConcatenation obj = new SubstringwithConcatenation();

        System.out.println(obj.findSubstring("foobarfoobar",arr));
        System.out.println(obj.prem);
    }
}
