public class GetNumberOddEven {
    public static boolean Iseven(int n){
        if ((n & 1)==0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Iseven(5));
    }
}
