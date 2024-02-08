public class RemoveDupplecate {
    static int arr[] = new int[26];
    public static String removeDupplecate(String s,int i,StringBuilder str){

        if (i == s.length()) {
            return str.toString();
        }
        if(arr[s.charAt(i)-'a']==0){
            str.append(s.charAt(i));
            arr[s.charAt(i)-'a']++;
        }
        return removeDupplecate(s,i+1,str);
    }

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("");
        System.out.println(removeDupplecate("zsdezesfflhekusfhykdjf",0,s1));
    }
}
