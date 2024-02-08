import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlight {

    static class Edge{
        int src,dst,wet;
        Edge(int src,int dst,int wet){
            this.src =src;
            this.wet=wet;
            this.dst =dst;
        }
    }

    public int getCheapest(int n,int info[][],int src,int dest,int k){
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int arr[]:info){
            graph[arr[0]].add(new Edge(arr[0],arr[1],arr[2]));
        }
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0,0});
        while (!q.isEmpty()){
           int curr[]= q.remove();
           int node = curr[0];
           int cost = curr[1];
           int stop = curr[2];
            System.out.println(node+" "+cost+" "+stop);
            if (stop >k) {
                break;
            }
            for (int i = 0; i <graph[node].size() ; i++) {
                Edge e = graph[node].get(i);
                if ( dist[e.dst] > dist[node]+e.wet) {
                    dist[e.dst]=dist[node]+e.wet;
                }
                q.add(new int[]{e.dst,dist[e.dst],stop+1});
            }
        }
        return dist[dest];
    }

    public static void main(String[] args) {
        int info[][] = {{0,1,100},{1,2,100},{1,3,600},{2,0,100},{2,3,200}};

        int node = 4;
        CheapestFlight obj = new CheapestFlight();
        System.out.println(obj.getCheapest(node,info,0,3,1));
    }
}
