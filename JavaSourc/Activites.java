import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Activites {
    public static void activiesSelection(int start[],int end[]){
//        SORTED BY ENDING INDEX
        int data[][]=new int[start.length][3];
        for (int i = 0; i < start.length ; i++) {
            data[i][0]=i;
            data[i][1]=start[i];
            data[i][2]=end[i];
        }
        Arrays.sort(data, Comparator.comparingInt(o->o[2]));

        ArrayList<Integer> ac = new ArrayList<>();
        ac.add(data[0][0]);
        int currTask=0;
        for (int i = 1; i <start.length ; i++) {
            if (data[currTask][2]<=data[i][1]) {
                ac.add(data[i][0]);
                currTask=i;
            }
        }
        System.out.println(ac);
    }


    public static void main(String[] args) {
        int start[]={0,1,3,5,5,8};
        int end[]={6,2,4,7,9,9};
        activiesSelection(start,end);
    }
}
