public class BackTarcingInArray {
    public static void arrayMun(int arr[],int i,int val){
        if (i == arr.length) {
            for (int j = 0; j <arr.length ; j++) {
                System.out.print(arr[j]+" ");
            }
            return;
        }
        arr[i] = val;
        arrayMun(arr,i+1,val+1);
        arr[i] *=2;
    }

    public static void subString(String s,int i,String str){
        if (s.length() == i) {
            if (str == "") {
                System.out.println("\'\'");
                return;
            }
            System.out.println(str);

            return;
        }
        subString(s,i+1,str+s.charAt(i));
//        System.out.println("Chart :"+str);
        subString(s,i+1,str);
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
//        arrayMun(arr,0,1);
//        System.out.println();
//        for (int j = 0; j <arr.length ; j++) {
//            System.out.print(arr[j]+" ");
//        }
        String s= "SFE";
        subString(s,0,"");
    }
}
