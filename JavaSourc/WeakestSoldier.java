import java.util.Comparator;
import java.util.PriorityQueue;

public class WeakestSoldier {
    static class Row implements Comparable<Row> {
        int count;
        int idx;
        Row(int count,int idx){
            this.count = count;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row o) {
            if (o.count == this.count) {
                return this.idx-o.idx;
            }
            return this.count-o.count;
        }
    }
    public static void main(String[] args) {
        int soldier[][] = {
                {1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}
        };
        PriorityQueue<Row> r = new PriorityQueue<Row>();
        for (int i = 0; i < soldier.length ; i++) {
            int count = 0;
            for (int j = 0; j < soldier[0].length ; j++) {
              count+=soldier[i][j];
            }
            r.add(new Row(count,i));
        }
        while (!r.isEmpty()){
            System.out.println("C"+r.remove().idx);
        }
    }
}
