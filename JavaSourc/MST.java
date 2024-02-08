import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MST {

    static class Edge{
        int src,dest,wet;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest=d;
            this.wet = w;
        }
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int wight;
        Pair(int node,int wight){
            this.node = node;
            this.wight =wight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wight-o.wight;
        }
    }

    public void Primes(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int cost = 0;
        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if (!visited[curr.node]) {
                cost+=curr.wight;
                visited[curr.node] =true;
                for (int i = 0; i <graph[curr.node].size() ; i++) {
                    pq.add(new Pair(graph[curr.node].get(i).dest,graph[curr.node].get(i).wet));
                }
            }
        }
        System.out.println(cost);
    }

    static class Info {
        int src,cost,stop;
        Info(int src,int cost,int stop){
            this.src = src;
            this.cost = cost;
            this.stop = stop;
        }
    }


    public int ChipestPath(ArrayList<Edge> graph[],int src,int dest,int k){
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length ; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0,0,0));
        boolean visited[] = new boolean[graph.length];
        int stop = -1;
        while (!q.isEmpty()){
            Info curr = q.remove();
            if (curr.stop >k) {
                break;
            }
            if (!visited[curr.src]) {
                visited[curr.src] = true;
                for (int i = 0; i <graph[curr.src].size() ; i++) {
                    Edge e = graph[curr.src].get(i);

                    if(dist[e.dest]>dist[curr.src]+e.wet){
                        dist[e.dest] = dist[curr.src]+e.wet;
                    }
                    if (e.dest == dest) {
                        System.out.println("Src :"+dest+" Cost :"+ dist[e.dest]);
                    }
                    q.add(new Info(e.dest,dist[e.dest],curr.stop+1));
                }
            }
            }

       return dist[dest];
    }

    public void CraeteGraph(ArrayList<Edge>[] graph, int v){

        for (int i = 0; i <v ; i++) {
            graph[i] = new ArrayList<>();
        }
//---------------------------------------------------------------------------------

//        graph[0].add(new Edge(0,3,3)) ;
//        graph[0].add(new Edge(0,4,12)) ;
//
//        graph[1].add(new Edge(1,3,5)) ;
//        graph[1].add(new Edge(1,2,2)) ;
//
//
//        graph[2].add(new Edge(2,3,3)) ;
//        graph[2].add(new Edge(2,1,2)) ;
//        graph[2].add(new Edge(2,4,7)) ;
//
//        graph[3].add(new Edge(3,0,3)) ;
//        graph[3].add(new Edge(3,2,3)) ;
//        graph[3].add(new Edge(3,1,5)) ;
//
//        graph[4].add(new Edge(4,2,7)) ;
//        graph[4].add(new Edge(4,0,12)) ;
//---------------------------------------------------------------------------------
//        graph[5].add(new Edge(5,0,1)) ;
//        graph[5].add(new Edge(5,2,1)) ;

        graph[0].add(new Edge(0,1,100)) ;

        graph[1].add(new Edge(1,2,100)) ;
        graph[1].add(new Edge(1,3,600)) ;
        graph[2].add(new Edge(2,0,100)) ;
        graph[2].add(new Edge(2,3,200)) ;

//        graph[0].add(new Edge(0,3,3)) ;
    }
    
    public static void main(String[] args) {
        MST obj = new MST();
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        obj.CraeteGraph(graph,v);
//        obj.Primes(graph);

        System.out.println(obj.ChipestPath(graph,0,3,1));
    }
}
