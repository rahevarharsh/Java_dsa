public class Trapping_Rain_Water {
    public static int trap(int[] height) {
        int val = 0;
        int rightMax[] = new int[height.length];
        int leftMax[] = new int[height.length];
        leftMax[0]=height[0];
        for (int i = 1; i < height.length ; i++) {
            leftMax[i] = Integer.max(leftMax[i-1],height[i]);
        }
        rightMax[0] = height[height.length-1];
        for (int i = 1; i <height.length ; i++) {
            rightMax[i] = Integer.max(rightMax[i-1],height[height.length-i-1]);
        }
        for (int i = 0; i < height.length ; i++) {
            val += Integer.min(rightMax[height.length-i-1],leftMax[i])-height[i];
        }
        return val;
    }
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
