import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int maxLen =0;
        for (int right = 0,left=0; right <s.length() ; right++) {
            char curr=s.charAt(right);
            int idx = s.indexOf(curr,left);
            if(idx!=right){
                left = idx+1;
            }
            maxLen =Math.max(maxLen,right-left+1);
        }
        System.out.println(maxLen);
        return 0;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring(s));
//        System.out.println(s.indexOf('b',0));
    }
}
