import java.util.Stack;

public class Stock_price_by_stack {
    public static void stock_interval(int stocks[],int span[]){
        Stack s = new Stack();
        s.add(0);
        span[0] = 1;
        for (int i = 1; i < stocks.length ; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty()&& currPrice>stocks[(int)s.peek()] ){
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i+1;
            }else{
                span[i] = i-(int)s.peek();
            }
            s.add(i);
        }
    }
    public static void main(String[] args) {
        int stocks[] = {100,80,60,70,60,85,10,1000,100};
        int span[] = new int[stocks.length];
        stock_interval(stocks,span);
        for(int v:span){
            System.out.print(v+" ");
        }
    }
}
