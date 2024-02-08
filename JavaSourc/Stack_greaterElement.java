import java.util.Stack;

public class Stack_greaterElement {

    public static void greaterElement(int nums[],int grater[]){
        Stack<Integer> stk = new Stack<>();
        for (int i = nums.length-1; i >=0 ; i--) {
            while (!stk.isEmpty()&&nums[i]>nums[stk.peek()]){
                stk.pop();
            }
            if(stk.isEmpty()){
                grater[i] = -1;
            }
            else{
                grater[i]= nums[stk.peek()];
            }
            stk.push(i);
        }
    }
    public static void main(String[] args) {
        int nums[] = {6,8,0,1,3};
        int grater[]=new int[nums.length];
        greaterElement(nums,grater);
        for(int v:grater){
            System.out.print(v+" ");
        }
    }
}
