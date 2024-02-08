public class ClearNthBit {
    public static int clearbit(int n,int i){
        return n&(~(1<<i));
    }

    public static void main(String[] args) {
        System.out.println(clearbit(15,2));
    }
}
