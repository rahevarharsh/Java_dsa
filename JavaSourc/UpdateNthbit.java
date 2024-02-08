public class UpdateNthbit {
    public static int update(int n,int i,int m){
//        clear bit
        int clrNum = n&(~(1<<i));
        return clrNum|(m<<i);
    }

    public static void main(String[] args) {
        System.out.println(update(10,0,1));
    }
}
