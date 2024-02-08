public class Tiling {
    public static int Tiling_ways_2Xn(int n){
        if (n == 0 || n==1) {
            return 1;
        }
        return Tiling_ways_2Xn(n-1)+Tiling_ways_2Xn(n-2);
    }

    public static void main(String[] args) {
        System.out.println(Tiling_ways_2Xn(6));
    }
}
