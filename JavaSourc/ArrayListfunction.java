import java.util.ArrayList;
import java.util.Collections;

public class ArrayListfunction {

    public static void swapArrayList(ArrayList<Integer> al,int idx1,int idx2){
        int temp = al.get(idx1);
        al.set(idx1, al.get(idx2));
        al.set(idx2,temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(5);
        al.add(2);
        al.add(7);
        al.add(1);
        al.add(3);
//----------------------------------------------------------------------------------------
//        System.out.println(al);
//        swapArrayList(al,1,3);
//        System.out.println(al);

//        SORt array list -------------------------------------------------------------
//        Collections.sort(al);
//        System.out.println(al);
//        Collections.sort(al,Collections.reverseOrder());
//        System.out.println( al);

    }
}
