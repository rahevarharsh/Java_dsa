import java.util.HashMap;

public class SubArraySum {

    public int SubArraySumK(int arr[],int k){
        HashMap<Integer,Integer> track = new HashMap<>();
        int count = 0;
        int sum=0;
        for (int i = 0; i < arr.length ; i++) {
            sum +=arr[i];
            if (sum==k) {
                count++;
            }
            else if (track.containsKey(sum-k)) {
                count++;
            }
            track.put(sum,1);
        }
        return count;
    }
    public int OptimiseSubArraySumK(int arr[],int k){
        HashMap<Integer,Integer> track = new HashMap<>();
        int count = 0;
        int sum=0;
        track.put(0,1);
        for (int i = 0; i < arr.length ; i++) {
            sum+=arr[i];
            if (track.containsKey(sum-k)) {
                count+=track.get(sum-k);
            }
            track.put(sum,track.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
//        int arr[]={3,4,7,2,-3,1,4,2};
        int arr[]={10,2,-2,-20,10};

        int k=-10;
        SubArraySum obj = new SubArraySum();
        System.out.println(obj.SubArraySumK(arr,k));
        System.out.println(obj.OptimiseSubArraySumK(arr,k));

    }
}
