public class Distribute_Money_to_Maximum_Children {
    public static int distMoney(int money, int children) {
        if(money<children){return -1;}
        int numkid = 0;
        money-=children;
        while (money>0){
            if (money-8==4) {
                if (money-9>=0) {
                    money-=9;
                }
                else{
                    money-=7;
                }
            }
            else if (money-8>=0) {
                money-=8;
                numkid++;
            }
            else{
                money=0;
            }
        }

        return numkid;
    }
    public static void main(String[] args) {

        System.out.println(distMoney(2,2));
    }
}
