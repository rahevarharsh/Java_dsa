public class ClearBitsNumberJtoI {
    public static int clearBitsJtoI(int n,int j,int i){
        int a = ~(0)<<j;
        int b = (1<<i)-1;
        return n & (a|b);
    }
    public static void main(String[] args) {
        System.out.println(clearBitsJtoI(15,2,0));
    }
}
