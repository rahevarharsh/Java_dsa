import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversalBFS {
    static class Edge{
        int src,dest,wet;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest=d;
            this.wet = w;
        }
    }


    public void DFS(ArrayList<Edge>[] graph,int curr,boolean visied[]){
        visied[curr] = true;

        System.out.print(curr+" --> ");
        for (int i = 0; i <graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);
            if (!visied[e.dest] ) {
                DFS(graph, e.dest, visied);
            }
        }
    }



    public void BFS(ArrayList<Edge>[] graph){
        Queue<ArrayList<Edge>> q = new LinkedList<>();
        q.add(graph[0]);
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < visited.length ; i++) {
            visited[i] = false;
        }
        while (!q.isEmpty()){
            ArrayList<Edge> curr = q.remove();
            int element = curr.get(0).src;
            if (!visited[element]) {
                for (int i = 0; i <curr.size() ; i++) {
                    q.add(graph[curr.get(i).dest]);
                }
                System.out.print(element+" --> ");
                visited[element] = true;
            }

        }
    }

    public boolean hasPath(ArrayList<Edge> graph[],int curr,int destiny,boolean visited[]){
        System.out.println(curr+" -->");
        if (graph[curr].get(0).src==destiny) {
            return true;
        }
        boolean ans = false;
        visited[curr] =true;
        for (int i = 0; i <graph[curr].size() ; i++) {
            if (!visited[graph[curr].get(i).dest]&&hasPath(graph,graph[curr].get(i).dest,destiny,visited)) {
                return true;
            }
        }
        System.out.println("bottom :"+curr);
        return false;
    }

    public void CraeteGraph(ArrayList<Edge>[] graph,int v){
    
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

        graph[0].add(new Edge(0,1,1)) ;
        graph[0].add(new Edge(0,2,1)) ;

        graph[1].add(new Edge(1,3,1)) ;
        graph[1].add(new Edge(1,0,1)) ;

        graph[2].add(new Edge(2,0,1)) ;
        graph[2].add(new Edge(2,4,1)) ;

        graph[3].add(new Edge(3,1,1)) ;
        graph[3].add(new Edge(3,4,1)) ;
        graph[3].add(new Edge(3,5,1)) ;

        graph[4].add(new Edge(4,2,1)) ;
        graph[4].add(new Edge(4,3,1)) ;
        graph[4].add(new Edge(4,5,1)) ;

        graph[5].add(new Edge(5,3,1)) ;
        graph[5].add(new Edge(5,4,1)) ;
        graph[5].add(new Edge(5,6,1)) ;

        graph[6].add(new Edge(6,5,1)) ;

        graph[7].add(new Edge(7,8,1)) ;

        graph[8].add(new Edge(8,7,1)) ;
        graph[8].add(new Edge(8,9,1)) ;
        graph[8].add(new Edge(8,10,1)) ;

        graph[9].add(new Edge(9,8,1)) ;
        graph[9].add(new Edge(9,10,1)) ;

        graph[10].add(new Edge(10,8,1)) ;
        graph[10].add(new Edge(10,9,1)) ;
    }
    
    public static void main(String[] args) {
        int v = 11;
        ArrayList<Edge> graph[] = new ArrayList[v];
        GraphTraversalBFS obj = new GraphTraversalBFS();
        obj.CraeteGraph(graph,v);
//        for (int i = 0; i <graph[3].size() ; i++) {
//            System.out.println(graph[3].get(i).dest);
//        }
//        obj.BFS(graph);
        boolean visited[] = new boolean[v];
        for (int i = 0; i <v ; i++) {
            visited[i] = false;
        }
//        System.out.println();
//        obj.DFS(graph,0,visited);

        System.out.println(obj.hasPath(graph,0,5,visited));
    }
}
