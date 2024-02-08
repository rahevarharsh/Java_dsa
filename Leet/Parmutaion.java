public class Parmutaion {
    public static void parmutaion(int arr[],int i){
        if (i == arr.length) {
            System.out.print("[");
            for (int j = 0; j <arr.length ; j++) {
                System.out.print(" "+arr[j]+" ");
            }
            System.out.println("]");
        }
        for (int j = i; j < arr.length ; j++) {
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
            parmutaion(arr,i+1);
            temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
    }
    public static String tel[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void telephoneAlph(int arr[],int i,String temp){
        if (arr.length == i) {
            System.out.println(temp);
            return;
        }
        for (int j = 0; j <tel[arr[i]].length() ; j++) {
            telephoneAlph(arr, i+1, temp+tel[arr[i]].charAt(j));
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,3};
//        parmutaion(arr,0);
        telephoneAlph(arr,0,"");
    }
}
