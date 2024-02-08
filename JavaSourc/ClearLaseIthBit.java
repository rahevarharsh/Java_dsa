public class ClearLaseIthBit {
    public static int clearlasebits(int n,int i){
        return (~(0)<<i)&n;
    }

    public static void main(String[] args) {
        System.out.println(clearlasebits(15,3));
    }
}
