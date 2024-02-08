import java.util.ArrayList;

public class Form_Smallest_Number_From_Two_Digit_Arrays {
    public static int minNumber(int[] nums1, int[] nums2) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i <nums1.length ; i++) {
            for (int j = 0; j <nums2.length ; j++) {
                if (nums1[i]==nums2[j]){
                    al.add(nums1[i]);
                }
            }
        }
        int minCom = Integer.MAX_VALUE;
        for (int i = 0; i < al.size() ; i++) {

            minCom = Integer.min(al.get(i),minCom);
        }
        if (al.size()!=0){
            return minCom;
        }
        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i <nums1.length ; i++) {
            min1 = Math.min(min1,nums1[i]);
        }
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i <nums2.length ; i++) {
            min2 = Math.min(min2,nums2[i]);
        }
        System.out.println(min1+" "+min2);
        if (min1>min2){
            return min2*10+min1;
        }
        return min1*10+min2;
    }
    public static void main(String[] args) {
        int n1[] = {4,1,3};
        int n2[] = {5,7};
        System.out.println(minNumber(n1,n2));
    }
}
