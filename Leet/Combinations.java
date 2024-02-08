import java.util.ArrayList;
import java.util.List;


public class Combinations {
List<List<Integer>> ans = new ArrayList<>();
    public void halper (int n,int k,ArrayList<Integer> temp,int curr){
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = curr; i <=n ; i++) {
            temp.add(i);
            halper(n,k-1,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        halper(n,k,new ArrayList<Integer>(),1);
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Combinations cb= new Combinations();
        cb.combine(1,1);
    }
}
