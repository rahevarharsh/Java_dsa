public class SpirelArrayElement {
    public static void PrintSpirelElementArray(int arr[][]){
    int start_col=0,start_row=0;
    int end_col=arr[0].length-1,end_row=arr.length-1;
    while (start_col<=end_col&&start_row<=end_row){
        for (int i = start_col; i <=end_col ; i++) {
            System.out.print(arr[start_row][i]+" ");
        }

        for (int i = start_row+1; i <=end_row ; i++) {
            System.out.print(arr[i][end_col]+" ");
        }

        for (int i = end_col-1; i >=start_col ; i--) {
            System.out.print(arr[end_row][i]+" ");
        }

        for (int i = end_row-1; i > start_row; i--) {
            System.out.print(arr[i][start_col]+" ");
        }

        start_row++;
        start_col++;
        end_col--;
        end_row--;
    }
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        PrintSpirelElementArray(arr);
    }
}
