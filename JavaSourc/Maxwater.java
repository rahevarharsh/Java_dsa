import java.util.ArrayList;

public class Maxwater {
    public static int maxwater(ArrayList<Integer> list){
        int max = 0;
        int l = 0;
        int r = list.size()-1;
        while (l<r){
         int height = Integer.min(list.get(l), list.get(r));
         int area = height*(r-l);
         max = Integer.max(area,max);
           if (list.get(l)< list.get(r)) {
               l++;
           }
           else{r--;}
       }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
//        1,8,6,2,5,4,8,3,7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(height);
        System.out.println(maxwater(height));
    }
}
