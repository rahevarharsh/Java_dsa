public class Quee_usingArray {
    static class Quee{
        static int size;
        static int arr[];
        static int rear;
        Quee(int n){
            size = n;
            rear = -1;
             arr = new int[n];
        }
        static void add(int data){

            if (isFull()) {
                System.out.println("Quee is full!");
                return;
            }
            arr[++rear]=data;
        }
        static boolean isEmpty(){
            return rear==-1;
        }
        static boolean isFull(){
            return rear==size-1;
        }
        static int peek(){
            if (isEmpty()) {
                System.out.println("Empty!");
                return -1;
            }
            return arr[0];
        }
        static void remove(){
            if (isEmpty()) {
                System.out.println("Quee is empty!");
                return;
            }
            int i=0;
            while (i<rear){
                arr[i] = arr[i+1];
                i++;
            }
            rear--;
        }
    }
    public static void main(String[] args) {

    Quee q = new Quee(3);
        System.out.println(q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        System.out.println(q.peek());
        q.add(17);
        q.add(18);
        q.add(19);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
