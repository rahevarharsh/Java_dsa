import java.util.*;
public class MinimumSumofFourDigitNumberAfterSplittingDigits {


    public int minimumSum(int num) {
        int n = num;
        int i =0;
        int arr[] = new int[4];
        while (n>0){
            int digit = n%10;
            arr[4-i++-1] = digit;
            n=n/10;
        }
        Arrays.sort(arr);
        int num1=arr[0]*10+arr[3];
        int num2=arr[1]*10+arr[2];
        return num1+num2;
    }

    public static void main(String[] args) {
    MinimumSumofFourDigitNumberAfterSplittingDigits obj = new MinimumSumofFourDigitNumberAfterSplittingDigits();
    obj.minimumSum(2932);
    }

}
