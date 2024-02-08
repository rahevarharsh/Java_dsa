public class GetnthBit {
    public static int getBit(int n,int pos){
        int sample = 1<<pos;
        if ((n&sample)==0) {
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {

        System.out.println(getBit(5,0));
    }
}
