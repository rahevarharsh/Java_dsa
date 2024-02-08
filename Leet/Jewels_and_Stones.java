public class Jewels_and_Stones {
    public static void main(String[] args) {
    Solution2 s = new Solution2();
//    s.numJewelsInStones("aA","aAAbbbb");
        System.out.println( s.numJewelsInStones("aA","aAAbbbb"));
    }
}
class Solution2 {
    public int numJewelsInStones(String jewels, String stones) {
        int[] stoneCount = new int[100];
        for (int i = 0; i <stones.length() ; i++) {
            stoneCount[stones.charAt(i)]++;
        }
        int sum=0;
        for (int i = 0; i <jewels.length() ; i++) {
            sum += stoneCount[jewels.charAt(i)];
        }
        return sum;
    }
}