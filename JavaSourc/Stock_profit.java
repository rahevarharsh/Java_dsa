public class Stock_profit {
    public static void Max_profit(int arr[]){
        int max_profit = 0;
        int min_buy_price = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            int profit = arr[i]-min_buy_price;
            max_profit = Integer.max(max_profit,profit);
            min_buy_price = Integer.min(min_buy_price,arr[i]);
        }
        System.out.println(max_profit);
    }

    public static void main(String[] args) {
        int arr[]={50,35,100,7,1,5,3,6,4};
        Max_profit(arr);
    }
}
