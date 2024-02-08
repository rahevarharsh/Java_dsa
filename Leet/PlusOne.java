import java.util.ArrayList;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int cury = 0;
        digits[digits.length-1] +=1;
        for (int i = digits.length-1; i >=0 ; i--) {
            digits[i]+=cury;
            if (digits[i]>9) {
                digits[i] = (digits[i])%10;
                cury=1;
            }
            else cury=0;
        }
        if (cury !=0 ) {
            int rearr[] = new int[digits.length+1];
            rearr[0] =cury;
            for (int i = 0; i < digits.length ; i++) {
                rearr[i+1]=digits[i];
            }
            System.out.println();
            return rearr;
        }

    return digits;
    }

    public static void main(String[] args) {
//        System.out.println(14%10);
        PlusOne obj = new PlusOne();
        int digits[] = {1,2,3};
        ;
        for (int i :obj.plusOne(digits)) {
            System.out.print(i+" ");
        }
    }
}
