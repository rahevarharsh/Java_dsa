import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MajorityElement {
    public ArrayList<Integer> majority(int arr[]){
        HashMap<Integer,Integer> frq = new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
            if (frq.containsKey(arr[i])) {
               int pf= frq.get(arr[i]);
                frq.replace(arr[i],++pf );
            }
            else{
                frq.put(arr[i],1 );
            }
        }
        int thre = arr.length/3;
        ArrayList<Integer> ans = new ArrayList<>();
       Set<Integer> keys = frq.keySet();
        for (int d:keys) {
            if(frq.get(d)>thre){
                ans.add(d);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2};
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.majority(arr));
    }
}
