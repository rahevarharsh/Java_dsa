import java.util.Arrays;
import java.util.Comparator;

public class Job_sequencing {

    public static void main(String[] args) {
        int deadLine[] ={4,3,1,1};
        int profit[]={20,100,40,30};
        int job[][] = new int[deadLine.length][3];
        for (int i = 0; i < deadLine.length ; i++) {
            job[i][0]=i;
            job[i][1]=deadLine[i];
            job[i][2]=profit[i];
        }
        Arrays.sort(job,Comparator.comparingDouble(o->o[2]));
        int deadLine_count = 0;
        int max_profit=0;
        for (int i = deadLine.length-1; i >=0 ; i--) {
            if(deadLine_count<job[i][1]){
                deadLine_count++;
                System.out.println("deadLine :"+job[i][1]+" profit :"+job[i][2]);
                max_profit+=job[i][2];
            }
        }
        System.out.println(max_profit);
    }
}
