public class Shuffle_String {
    public static String restoreString(String s, int[] indices) {
    char[] temp = new char[s.length()];
        for (int i = 0; i < indices.length ; i++) {
            temp[indices[i]]=s.charAt(i);
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i <temp.length ; i++) {
            sb.append(temp[i]) ;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
      String s = "codeleet";
      int [] ind = {4,5,6,7,0,2,1,3};

        System.out.println(restoreString(s,ind));
    }
}
