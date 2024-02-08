public class FindtheWidthofColumnsofaGrid {

    public int retunrMaxlen(int arr[]){
        int len = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]>0){
                if (Math.pow(10,len)<=arr[i]) {
                    int e = len;
                    while (Math.pow(10,e)<=arr[i]){
                        e++;
                    }
                    len = e;
                }
            }
            else{
                if ((int)Math.pow(10,len-1)*-1>=arr[i]) {
                    int e = len;
                    while (Math.pow(10,e-1)*-1>=arr[i]){
                        e++;
                    }
                    len = e;
                }
            }
        }
        return len;
    }


    public int[] findColumnWidth(int[][] grid) {

        int returnArr[] = new int[grid[0].length];
//        System.out.println(grid[2][0]);
        for (int i = 0; i < grid[0].length ; i++) {
            int temp[] = new int[grid.length];
            for (int j = 0; j < grid.length ; j++) {
                temp[j] = grid[j][i];
            }
            returnArr[i] = retunrMaxlen(temp);
        }
        return returnArr;
    }

    public static void main(String[] args) {
        int arr[][] = {{-15,1,3}, {15,7,12}, {5,6,-2}};
        FindtheWidthofColumnsofaGrid obj = new FindtheWidthofColumnsofaGrid();
        obj.findColumnWidth(arr);
    }
}
