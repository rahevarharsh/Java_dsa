public class FloodFill {


    public void filler(int arr[][],int sr,int sc,boolean visited[][],int color,int precolor){

        if (sr<0 || sr>=arr.length||sc<0||sc>= arr[0].length||arr[sr][sc]!=precolor) {
            return;
        }
        if (visited[sr][sc]) {
            return;
        }
        arr[sr][sc] = color;
        visited[sr][sc] = true;
        filler(arr, sr-1, sc, visited, color, precolor);
        filler(arr, sr+1, sc, visited, color, precolor);
        filler(arr, sr, sc+1, visited, color, precolor);
        filler(arr, sr, sc-1, visited, color, precolor);

    }

    public void Fill(int arr[][],int sr,int sc){
        boolean visited[][] = new boolean[arr.length][arr[0].length];
        filler(arr,sr,sc,visited,2,arr[sr][sc]);
    }

    public static void main(String[] args) {
        int arr[][] = {{1,1,1},{1,1,0},{0,0,1}};
        FloodFill obj = new FloodFill();
        obj.Fill(arr,1,1);
        for(int a[]:arr){
            for (int i :a) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
