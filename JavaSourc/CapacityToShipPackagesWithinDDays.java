import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {

    public void halper(int[] weights,int days,int sum,int currDay,int idx){
        if (idx >= weights.length) {
            return;
        }
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum =0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length ; i++) {
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {3,2,2,4,1,4};
        int days = 3;
        CapacityToShipPackagesWithinDDays obj = new CapacityToShipPackagesWithinDDays();
        obj.shipWithinDays(arr,days);
    }

}
