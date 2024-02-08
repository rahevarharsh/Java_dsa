import java.util.ArrayList;
import java.util.Collections;

public class DisjointSetUnion {

    static class Edge{
        int src;
        int des;
        int cost;
        Edge(int src,int des,int cost){
            this.src = src;
            this.des = des;
            this.cost = cost;
        }

//        @Override
//        public int compareTo(Edge e2) {
//            return Integer.compare(this.cost, e2.cost);
//        }
    }

    public void init(int rank[],int par[]){
        for (int i = 0; i < rank.length; i++) {
            par[i] = i;
            rank[i]=0;
        }
    }

    public int FindParents(int par[],int i){
        if (par[i] == i) {
            return i;
        }
        return par[i] = FindParents(par,par[i]);
    }

    public void Union(int par[],int rank[],int a,int b){
        int parA = FindParents(par,a);
        int parB = FindParents(par,b);
        int hightA = rank[parA];
        int hightB = rank[parB];
        if (hightA==hightB) {
            par[parB] = parA;
            rank[parA]++;
        }
        else if (hightA<hightB) {
            par[parA] = parB;
        }
        else{
            par[parB] = parA;
        }
    }

    public int Kuskal(ArrayList<Edge> edges,int rank[],int par[]){
        int cost = 0;
        int idx = 0;
        int i = 0;
        while ( i <rank.length && idx<edges.size() ) {
            Edge e = edges.get(idx++);
            System.out.println(e.src+"  "+e.des+"  "+e.cost);
            int ParA = FindParents(par,e.src);
            int ParB = FindParents(par,e.des);
            if (ParA == ParB) {
                i--;
                continue;
            }
            Union(par,rank,ParA,ParB);
            cost+=e.cost;
        }
        System.out.println(cost);
        return cost;
    }



    public void PrintRankPar(int rank[],int par[]){
        for (int i = 0; i < rank.length ; i++) {
            System.out.println("Parents : "+par[i]+" Ranks : "+rank[i]+" ");
        }
    }

    public static void main(String[] args) {
        int rank[] = new int[4];
        int par[] = new int[4];
        DisjointSetUnion obj = new DisjointSetUnion();
        obj.init(rank,par);

        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,0,10));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,0,15));
        edges.add(new Edge(2,3,50));
        edges.add(new Edge(3,0,30));
        edges.add(new Edge(3,1,40));
        edges.add(new Edge(3,2,50));
        Collections.sort(edges,(e1,e2)->e1.cost- e2.cost);
        obj.Kuskal(edges,rank,par);

//
//        System.out.println(obj.FindParents(par,1));
//        obj.Union(par,rank,1,3);
//        obj.Union(par,rank,2,4);
//        obj.Union(par,rank,2,1);

        obj.PrintRankPar(rank,par);

    }

}
