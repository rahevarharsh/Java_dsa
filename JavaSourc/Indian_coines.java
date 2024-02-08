public class Indian_coines {
    public static void main(String[] args) {
        int coines[]= {2000,500,100,50,20,10,5,2,1};
        int amount = 1059;
        for (int i = 0; i < coines.length ; i++) {
            if (coines[i]<=amount) {
                    amount-=coines[i];
                    System.out.println(coines[i]);
                    i--;
            }
        }
    }
}
