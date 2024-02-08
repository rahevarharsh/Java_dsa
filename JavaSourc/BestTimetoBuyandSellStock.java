import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class BestTimetoBuyandSellStock {


    public int maxProfit(int[] prices) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2-o1));
//        int profit = 0;
//        pq.add(prices[prices.length-1]);
//        for (int i = prices.length-2; i >=0 ; i--) {
//            int max = pq.peek();
//            profit = Math.max(profit,max-prices[i]);
//            pq.add(prices[i]);
//        }
//        return profit;


        int min = prices[0];
        int profit = 0;
        for (int i = 1; i <prices.length ; i++) {
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i]-min);
        }
        System.out.println(profit);
        return profit;
    }

    public static void main(String[] args) {

    int arr[] = {7, 1, 5, 3, 6, 4};
    BestTimetoBuyandSellStock obj = new BestTimetoBuyandSellStock();
    obj.maxProfit(arr);
    }
}
