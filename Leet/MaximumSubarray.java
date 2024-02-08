public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int low = Integer.MAX_VALUE;
        int lowIndex = 0,upperIndex=0;
        int sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            sum+=nums[i];
            if (sum<low) {
                lowIndex = i;
            }
            low = Math.min(sum,low);
        }
        if (lowIndex==0) {
            return sum;
        }
//        System.out.println(low+" "+lowIndex);
        sum = low;
        low = Integer.MIN_VALUE;
        for (int i = lowIndex+1; i < nums.length ; i++) {
            sum+=nums[i];
            if (sum>low) {
                upperIndex = i;
            }
            low = Math.max(sum,low);
        }
//        System.out.println(low+" "+upperIndex);
        int finalSum = 0;
        for (int i = lowIndex+1; i <=upperIndex ; i++) {
            System.out.println(nums[i]);
            finalSum+=nums[i];
        }
        System.out.println();
        return finalSum;
    }

    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();
        int arr[]= {5,4,-1,7,8};
        System.out.println(        obj.maxSubArray(arr));
    }
}
