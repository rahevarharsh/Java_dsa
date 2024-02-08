import java.util.HashMap;

public class LargestSubArr0Sum {
    public int LargestLength(int arr[]){
        HashMap<Integer,Integer> ans = new HashMap<>();
        int sum=0;
        int max_len = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum+=arr[i];
            if (ans.containsKey(sum)) {
                max_len  = Math.max(i-ans.get(sum),max_len);
            }
            else{
                ans.put(sum,i);
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        LargestSubArr0Sum obj = new LargestSubArr0Sum();
        int arr[]={15,-2,2,-8,1,7,10};
        System.out.println(obj.LargestLength(arr));
    }
}
