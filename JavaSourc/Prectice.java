public class Prectice {
    public static void Print_water_amount(int arr[]){
        int[] rightMax=new int[arr.length];
        int[] leftMax =new int[arr.length];
        int level = 0;
        for (int i = 0; i <leftMax.length ; i++) {
            level = Integer.max(level,arr[i]);
            leftMax[i] = level;
        }
        level = 0;
        for (int i = rightMax.length-1; i >=0 ; i--) {
            level = Integer.max(level,arr[i]);
            rightMax[i]=level;
        }
        int total_water = 0;
        for (int i = 0; i <arr.length ; i++) {
           int water = Integer.min(leftMax[i],rightMax[i])-arr[i];
            if (water >0) {
                total_water+=water;
            }
        }
        System.out.println(total_water);
    }

    public static void main(String[] args) {
        int arr[] = {4,2,0,6,3,2,5,7};
        Print_water_amount(arr);
    }
}
