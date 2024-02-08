public class StringComparison {
    public static String compresion(String str){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i <str.length() ; i++) {
            Integer count = 1;
            sb.append(str.charAt(i));
            while ((i<str.length()-1) && (str.charAt(i)==str.charAt(i+1))){
                count++;
                i++;
            }
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        System.out.println(sb);
        return str;
    }
    public static void main(String[] args) {
        compresion("abbbcccdddd");
    }
}
