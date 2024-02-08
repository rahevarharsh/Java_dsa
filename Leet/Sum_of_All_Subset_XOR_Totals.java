public class Sum_of_All_Subset_XOR_Totals {
    public static int sum = 0;
    public static void halper(int[] nums,int idx,int temp){
        if (idx==nums.length) {
//            System.out.println(temp);
            sum+=temp;
            return;
        }
        halper(nums,idx+1,temp^nums[idx]);
        halper(nums,idx+1,temp);
    }
    public int subsetXORSum(int[] nums) {
        halper(nums,0,0);
        return 0;
    }
    public static void main(String[] args) {
        Sum_of_All_Subset_XOR_Totals soa = new Sum_of_All_Subset_XOR_Totals();
        int arr[] = {5,1,6};
        soa.subsetXORSum(arr);
        System.out.println(sum);
    }
}
