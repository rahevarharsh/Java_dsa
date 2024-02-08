import java.util.*;

public class Dijstra {
    static class Edge{
        int src,dest,wet;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest=d;
            this.wet = w;
        }
    }
    
    static class Pair implements Comparable<Pair>{
        int n ;
        int wt;
        Pair(int n,int wt){
            this.n =n;
            this.wt =wt;
        }
       

        @Override
        public int compareTo(Pair o) {
            return this.wt-o.wt;
        }
    }

    
    public void Dijstraalgo(ArrayList<Edge>[] graph,int src){
        boolean visited[] = new boolean[graph.length];
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length ; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while (!pq.isEmpty()){
           Pair currPair =  pq.remove();
            if (!visited[currPair.n]) {
                visited[currPair.n] = true;
                for (int i = 0; i <graph[currPair.n].size() ; i++) {
                    Edge e = graph[currPair.n].get(i);
                    if (currPair.wt+e.wet<dist[e.dest]) {
                        dist[e.dest] = currPair.wt+e.wet;
                    }
                    pq.add(new Pair(e.dest,dist[e.dest]));
                }
            }
        }
        for(int i:dist){
            System.out.print(i+" ");
        }
    }

    public void Bellmanford(ArrayList<Edge> graph[],int src){
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }


        for (int i = 0; i <= graph.length-1 ; i++) {
            for (int j = 0; j < graph.length ; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    if (dist[graph[j].get(k).dest]>(dist[j]+graph[j].get(k).wet)) {
                        dist[graph[j].get(k).dest] =dist[j]+graph[j].get(k).wet;
                    }
                }
            }
            for (int j = 0; j < dist.length ; j++) {
                System.out.print(dist[j]+" ");
            }
            System.out.println();
        }
    }

    public void CraeteGraph(ArrayList<Edge>[] graph, int v){

        for (int i = 0; i <v ; i++) {
            graph[i] = new ArrayList<>();
        }
//

//        graph[0].add(new Edge(0,1,2)) ;
//        graph[0].add(new Edge(0,2,4)) ;
//
//        graph[1].add(new Edge(1,2,1)) ;
//        graph[1].add(new Edge(1,3,7)) ;
//
//        graph[2].add(new Edge(2,4,3)) ;
//
//        graph[3].add(new Edge(3,5,1)) ;
//
//        graph[4].add(new Edge(4,3,2)) ;
//        graph[4].add(new Edge(4,5,5)) ;

        graph[0].add(new Edge(0,1,6)) ;
        graph[0].add(new Edge(0,2,5)) ;
        graph[0].add(new Edge(0,3,5)) ;

        graph[1].add(new Edge(1,4,-1)) ;
//        graph[1].add(new Edge(1,3,7)) ;

        graph[2].add(new Edge(2,1,-2)) ;
        graph[2].add(new Edge(2,4,1)) ;

        graph[3].add(new Edge(3,2,-2)) ;
        graph[3].add(new Edge(3,5,-1)) ;

        graph[4].add(new Edge(4,6,3)) ;

        graph[5].add(new Edge(5,6,3)) ;

    }

    public static void main(String[] args) {
        Dijstra obj = new Dijstra();
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        obj.CraeteGraph(graph,v);
//        obj.Dijstraalgo(graph,0);
        obj.Bellmanford(graph,0);
    }
}
