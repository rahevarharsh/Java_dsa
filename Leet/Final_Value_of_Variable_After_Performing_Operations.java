public class Final_Value_of_Variable_After_Performing_Operations {
    public static void main(String[] args) {
    Solution1 s = new Solution1();
    String[] str ={"++X","++X","X--"};

        System.out.println(s.finalValueAfterOperations(str));
    }
}
class Solution1 {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for(int i=0;i<operations.length;i++){
            String s= operations[i];
            if(s.charAt(2)=='X'){
                if (s.charAt(0)=='+') {
                    System.out.println("++val");
                    ++val;
                }
                else{
                    System.out.println("--val");
                    --val;
                }
            }
            else{
                if (s.charAt(2)=='+') {
                    System.out.println("val++");
                    val++;
                }
                else{
                    System.out.println("val--");
                    val--;
                }
            }
        }
    return val;
    }
}