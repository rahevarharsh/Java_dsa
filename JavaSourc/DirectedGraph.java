import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraph {

    static class Edge{
        int src,dest,wet;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest=d;
            this.wet = w;
        }
    }

    public boolean IsCycle(ArrayList<Edge> graph[]){
        boolean stack[] = new boolean[graph.length];
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i <graph.length ; i++) {
            if (!visited[i]) {
                if (IsCycleUtile(graph,stack,visited,i)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean IsCycleUtile(ArrayList<Edge> graph[],boolean stack[],boolean visited[],int curr){
        visited[curr] =true;
        stack[curr]=true;
        for (int i = 0; i <graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            else if (!visited[e.dest]&&IsCycleUtile(graph, stack, visited, e.dest)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;


    }


    public void TopologicalSort(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> ts = new Stack<>();
        for (int i = 0; i < graph.length ; i++) {
            if (!visited[i]) {
                topologicalSortutile(graph,ts,visited,i);
            }
        }
        while (!ts.isEmpty()){
            System.out.print(ts.pop()+" --> ");
        }
    }
    public void topologicalSortutile(ArrayList<Edge> graph[],Stack<Integer> ts,boolean visited[],int curr){

        visited[curr] = true;
        for (int i = 0; i <graph[curr].size() ; i++) {
            if (!visited[graph[curr].get(i).dest]){
                topologicalSortutile(graph, ts, visited, graph[curr].get(i).dest);
            }

        }
        ts.push(curr);
    }

    public void getIndeg(ArrayList<Edge> graph[],int indeg[]){
        for (int i = 0; i < graph.length ; i++) {
            int curr =i;
            for (int j = 0; j <graph[curr].size() ; j++) {
                indeg[graph[curr].get(j).dest]++;
            }
        }
    }

    public void topologicalSortKahna(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        getIndeg(graph,indeg);
        Queue<Integer> q = new LinkedList<>();
        System.out.println();
        for (int i = 0; i < graph.length ; i++) {
            if (indeg[i]==0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()){
           int curr = q.remove();
            for (int i = 0; i <graph[curr].size() ; i++) {
                indeg[graph[curr].get(i).dest]--;
                if (indeg[graph[curr].get(i).dest]==0) {
                    q.add(graph[curr].get(i).dest);
                }
            }
            System.out.print(curr+" --> ");
        }
    }


    public boolean HasPath(ArrayList<Edge> graph[],int src,int des){
        if (src==des) {
            System.out.print(des+" ");
            System.out.println();
            return true;
        }
        for (int i = 0; i <graph[src].size() ; i++) {
            System.out.print(src+" ");
            HasPath(graph,graph[src].get(i).dest,des); {
            }
        }
        return false;
    }


    public void CraeteGraph(ArrayList<Edge>[] graph, int v){

        for (int i = 0; i <v ; i++) {
            graph[i] = new ArrayList<>();
        }
//

        graph[0].add(new Edge(0,3,1)) ;
        graph[2].add(new Edge(2,3,1)) ;
        graph[3].add(new Edge(3,1,1)) ;
        graph[4].add(new Edge(4,1,1)) ;
        graph[4].add(new Edge(4,0,1)) ;
        graph[5].add(new Edge(5,0,1)) ;
        graph[5].add(new Edge(5,2,1)) ;


//        graph[1].add(new Edge(1,3,1)) ;
//        graph[1].add(new Edge(1,3,1)) ;
//
//        graph[2].add(new Edge(2,1,1)) ;
//        graph[3].add(new Edge(3,4,1)) ;
//        graph[3].add(new Edge(3,5,1)) ;
//
//        graph[4].add(new Edge(4,5,1)) ;

//        graph[5].add(new Edge(3,4,1)) ;


//        graph[4].add(new Edge(4,3,1)) ;
    }

    public static void main(String[] args) {
        DirectedGraph obj = new DirectedGraph();
        int v = 6 ;
        ArrayList<Edge>[] graph = new ArrayList[v];
        obj.CraeteGraph(graph,v);
        System.out.println(obj.IsCycle(graph));
//        System.out.println();
//        obj.TopologicalSort(graph);
//        obj.topologicalSortKahna(graph);
        System.out.println();
        obj.HasPath(graph,5,1);
    }
}
