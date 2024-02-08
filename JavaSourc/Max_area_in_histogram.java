import java.util.Stack;

public class Max_area_in_histogram {


    public static int max_area(int arr[]){
        int rm[] = new int[arr.length];
        int lm[] = new int[arr.length];
        Stack<Integer> st= new Stack<>();
        for (int i = 0; i < arr.length ; i++) {
            while (!st.isEmpty()&&arr[i]<arr[st.peek()]){
                st.pop();
            }
            if (st.isEmpty()) {
                lm[i]=-1;
            }else{
                lm[i]=st.peek();
            }
            st.push(i);
        }

        Stack<Integer> st1= new Stack<>();
        for (int i = arr.length-1; i >= 0; i--) {
            while (!st1.isEmpty()&&arr[i]<arr[st1.peek()]){st1.pop();}
            if (st1.isEmpty()) {rm[i]= arr.length;}
            else{rm[i]=st1.peek();}
            st1.push(i);
        }

        int maxarea = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            int area = arr[i]*(rm[i]-lm[i]-1);
            maxarea = Integer.max(maxarea,area);
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int arr[] = {2,5};
        System.out.println(max_area(arr));
    }
}
