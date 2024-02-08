import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnetcted {

    static class Edge{
        int src,des;
        Edge(int src,int des){
            this.src =src;
            this.des = des;
        }
    }

    public void addNode(ArrayList<Edge> graph[],Stack<Integer> st,boolean visited[],int curr){
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        for (int i = 0; i <graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.des]) {
                addNode(graph, st, visited, e.des);
            }
        }
        st.add(curr);
    }

    public void transpose(ArrayList<Edge> graph[],ArrayList<Edge> trsgraph[]){
        for (int i = 0; i < trsgraph.length ; i++) {
            trsgraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length ; i++) {
            for (int j = 0; j <graph[i].size() ; j++) {
                Edge e = graph[i].get(j);
                trsgraph[e.des].add(new Edge(e.des,e.src));
            }
        }
    }

    public void getNode(ArrayList<Edge> graph[]){
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[graph.length];
        addNode(graph,st,visited,0);
        ArrayList<Edge> tregraph []= new ArrayList[graph.length];
        transpose(graph,tregraph);
        System.out.println(st);
        visited= new boolean[graph.length];
        while (!st.isEmpty()){
            int curr = st.pop();
            if (!visited[curr]) {
                DFS(tregraph,visited,curr);
            }
            System.out.println();
        }

    }

    public void DFS(ArrayList<Edge> graph[],boolean visited[],int curr){
        if (visited[curr]) {
            return;
        }
        System.out.print(curr+" ");
        visited[curr] =true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e= graph[curr].get(i);

                DFS(graph, visited, e.des);
        }
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        for (int i = 0; i <v ; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
        StronglyConnetcted obj = new StronglyConnetcted();
        obj.getNode(graph);

    }
}
