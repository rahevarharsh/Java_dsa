public class Maximum_Number_of_Words_Found_in_Sentences {
    public static void main(String[] args) {
        String str[] = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        Solution3 s = new Solution3();
        System.out.println(s.mostWordsFound(str));

    }
}
class Solution3 {

    public int wordsCount(String s){
        int count  = 1;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    public int mostWordsFound(String[] sentences) {
        int maxSpace = 0;
        for(String s : sentences){
            maxSpace = Integer.max(maxSpace,wordsCount(s)) ;
        }
        return maxSpace;
    }
}