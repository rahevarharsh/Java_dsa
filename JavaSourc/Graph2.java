import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph2 {

    static class Edge{
        int src,dest,wet;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest=d;
            this.wet = w;
        }
    }

    public void BFS(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length ; i++) {
            if (!visited[i]) {
//                System.out.println("IN");
                BFSUtile(graph,i,visited);

            }
        }
    }


    public void BFSUtile(ArrayList<Edge> graph[],int curr,boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        while (!q.isEmpty()){
            int getpeek = q.remove();
            if (!visited[getpeek]) {
                visited[getpeek] = true;
                System.out.print(getpeek+" --> ");
                for (int i = 0; i <graph[getpeek].size() ; i++) {
                    q.add(graph[getpeek].get(i).dest);
                }
            }
        }
    }

    public boolean detectCycle(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length ; i++) {
            if (!visited[i]) {
                if (detectCycleUtile(graph,i,-1,visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detectCycleUtile(ArrayList<Edge> graph[],int curr,int parent,boolean visited[]){
//            System.out.println(curr+" "+parent);
            visited[curr] = true;
            boolean decision =false;
            for (int i = 0; i <graph[curr].size() ; i++) {
                if (visited[graph[curr].get(i).dest]&&graph[curr].get(i).dest!=parent) {
                    return true;
                }
                else if (!visited[graph[curr].get(i).dest]) {
                    if (detectCycleUtile(graph, graph[curr].get(i).dest, curr, visited)) {
                        return true;
                    }
                }
            }

        return false;
    }



    public boolean bipartite(ArrayList<Edge>[] graph){
        int color[] = new int[graph.length];
        for (int i = 0; i < graph.length ; i++) {
            color[i]=-1;
        }
        for (int i = 0; i < graph.length ; i++) {
            if (color[i]==-1) {
                if (!bipartiteUtile(graph,color,i,-1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bipartiteUtile(ArrayList<Edge>[] graph,int color[],int curr,int prev){
        if (prev==-1) {
            color[curr]=0;
        }
        else if (color[curr] ==-1) {
            if (color[prev]==1) {
                color[curr]=0;
            }
            else{
                color[curr]=1;
            }
        }

        System.out.println("Color :"+color[curr]+" "+" Curr : "+curr);

        for (int i = 0; i <graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);
            if (color[e.dest]==-1) {
                if (!bipartiteUtile(graph, color, e.dest, curr)) {
                    return false;
                }
            }
            else{
                if (color[e.dest] == color[curr]) {
                    return false;
                }
            }
        }
        return true;
    }



    public void CraeteGraph(ArrayList<Edge>[] graph, int v){

        for (int i = 0; i <v ; i++) {
            graph[i] = new ArrayList<>();
        }
//                                                  9
//            1-----------3                       |  \
//         /              |  \                    |   \
//        /               |    \                  |    \
//        0               |     5------6    7-----8----10
//         \              |    /
//          \             |  /
//            2------------4
//
//        graph[0].add(new Edge(0,1,1)) ;
//        graph[0].add(new Edge(0,2,1)) ;
//
//        graph[1].add(new Edge(1,3,1)) ;
//        graph[1].add(new Edge(1,0,1)) ;
//
//        graph[2].add(new Edge(2,0,1)) ;
//        graph[2].add(new Edge(2,4,1)) ;
//
//        graph[3].add(new Edge(3,1,1)) ;
//        graph[3].add(new Edge(3,4,1)) ;
//        graph[3].add(new Edge(3,5,1)) ;
//
//        graph[4].add(new Edge(4,2,1)) ;
//        graph[4].add(new Edge(4,3,1)) ;
//        graph[4].add(new Edge(4,5,1)) ;
//
//        graph[5].add(new Edge(5,3,1)) ;
//        graph[5].add(new Edge(5,4,1)) ;
//        graph[5].add(new Edge(5,6,1)) ;
//
//        graph[6].add(new Edge(6,5,1)) ;
//
//        graph[7].add(new Edge(7,8,1)) ;
//
//        graph[8].add(new Edge(8,7,1)) ;
//        graph[8].add(new Edge(8,9,1)) ;
//        graph[8].add(new Edge(8,10,1)) ;
//
//        graph[9].add(new Edge(9,8,1)) ;
//        graph[9].add(new Edge(9,10,1)) ;
//
//        graph[10].add(new Edge(10,8,1)) ;
//        graph[10].add(new Edge(10,9,1)) ;

//                    2-------5
//                  /
//                 /
//        0-------1
//                 \
//                  \
//                    3---------4

//        graph[0].add(new Edge(0,1,1)) ;
//
//        graph[1].add(new Edge(1,2,1)) ;
//        graph[1].add(new Edge(1,3,1)) ;
//
//        graph[2].add(new Edge(2,5,1)) ;
//        graph[2].add(new Edge(2,1,1)) ;
//
//        graph[3].add(new Edge(3,1,1)) ;
//        graph[3].add(new Edge(3,4,1)) ;
//
//        graph[4].add(new Edge(4,3,1)) ;
//
//        graph[5].add(new Edge(5,2,1)) ;

//            1-----------4
//          /             |
//         /              |
//        0               |
//          \             |
//            \           |
//              2---------3

//        graph[0].add(new Edge(0,1,1)) ;
//        graph[0].add(new Edge(0,2,1)) ;
//
//        graph[1].add(new Edge(1,0,1)) ;
//        graph[1].add(new Edge(1,4,1)) ;
//
//        graph[2].add(new Edge(2,0,1)) ;
//        graph[2].add(new Edge(2,3,1)) ;
//
//        graph[3].add(new Edge(3,2,1)) ;
//        graph[3].add(new Edge(3,4,1)) ;
//
//        graph[4].add(new Edge(4,3,1)) ;
//        graph[4].add(new Edge(4,1,1)) ;







//           1------------3
//          /             |
//         /              |
//        0 --------------2
//
        graph[0].add(new Edge(0,1,1)) ;
        graph[0].add(new Edge(0,2,1)) ;

        graph[1].add(new Edge(1,0,1)) ;
        graph[1].add(new Edge(1,3,1)) ;

        graph[2].add(new Edge(2,0,1)) ;
        graph[2].add(new Edge(2,3,1)) ;

        graph[3].add(new Edge(3,2,1)) ;
        graph[3].add(new Edge(3,1,1)) ;
    }


    public static void main(String[] args) {
        Graph2 obj = new Graph2();
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        obj.CraeteGraph(graph,v);
        obj.BFS(graph);
        System.out.println();
        System.out.println(" DetectCycle :"+obj.detectCycle(graph));
        System.out.println();
        System.out.println(obj.bipartite(graph));
    }
}
