import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        else if(numRows==1){
            ans.add(new ArrayList<>(Arrays.asList(1)));
        }
        else{
            ans.add(new ArrayList<>(Arrays.asList(1)));
            ans.add(new ArrayList<>(Arrays.asList(1,1)));
            for (int i = 2; i <numRows ; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(1);
                System.out.println("i  :"+i);
                for (int j = 1; j <=i-1 ; j++) {
                    temp.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
                }
                temp.add(1);
                ans.add(temp);
            }
        }
        System.out.println(ans.toString());
        return ans;
    }

    public static void main(String[] args) {
        Pascal obj = new Pascal();
        obj.generate(5);

    }
}
