import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Knapsanck {
    public static int kanpsanck(int wight[],int value[],int capacity){
        double items[][] = new double[wight.length][2];
        for (int i = 0; i < wight.length ; i++) {
            items[i][0]=(double) i;
            items[i][1] = (double) value[i]/wight[i];
        }
        Arrays.sort(items, Comparator.comparingDouble(o->o[1]));
        ArrayList<Integer> it = new ArrayList<>();
        int profit = 0;
        for (int i = wight.length-1; i >=0 ; i--) {
            int idx = (int) items[i][0];
            if (capacity-wight[idx]>=0) {
                capacity-=wight[idx];
                profit+=value[idx];
            }else{
                profit+=items[i][1]*capacity;
                capacity=0;
                break;
            }
            System.out.println(capacity+" : "+profit);
        }
        System.out.println(it);
        return profit;
    }
    public static void main(String[] args) {
        int w[] = {10,20,30};
        int v[]={60,100,120};
        System.out.println(kanpsanck(w,v,50));
    }
}
