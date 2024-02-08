public class WaterLevel {
    public static void water_valume(int arr[]){
        int[] left_arr = new int[arr.length];
        int[] right_arr = new int[arr.length];
        int l_level = 0;
        for (int i = 0; i <left_arr.length ; i++) {
            l_level = Integer.max(l_level,arr[i]);
            left_arr[i] = l_level;
        }
        l_level = 0;
        for (int i = right_arr.length-1; i >=0 ; i--) {
            l_level = Integer.max(arr[i],l_level);
            right_arr[i] = l_level;
        }
       int Total_water =0;
        for (int i = 0; i <arr.length ; i++) {
           int water= Integer.min(left_arr[i],right_arr[i]) -arr[i];
           if(water>0){
               Total_water+=water;
           }
        }
        System.out.println(Total_water);
    }

    public static void main(String[] args) {
        int arr[] = {4,2,0,6,3,2,5};
        water_valume(arr);
    }
}
