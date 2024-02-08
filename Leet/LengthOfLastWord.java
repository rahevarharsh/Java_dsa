public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
       int i = s.length()-1;
       while (s.charAt(i)==' '){
           i--;
       }
       int count = 0;
       while (s.charAt(i)!=' '){
           count++;
           i--;
       }

        return count;
    }
    public static void main(String[] args) {
        int s = lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(s);
    }
}
