public class SetNthbit {
    public static int setbit(int n,int i){
        return ((n)|1<<i);
    }
    public static void main(String[] args) {
        System.out.println(setbit(2,1));
    }
}
