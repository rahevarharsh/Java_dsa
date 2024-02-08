import java.util.HashSet;
import java.util.Set;

public class FindMaximumNumberofStringPairs {

    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        for(String str:words){
            if (str.charAt(0) == str.charAt(1)) {
                continue;
            }
            set.add(str);
        }
        int count = 0;
        for (String str:words) {
            StringBuilder temp =new StringBuilder("");
            temp.append( str.charAt(1));
            temp.append(str.charAt(0));
//            System.out.println(temp.toString());
            if (set.contains(temp.toString())) {
                count++;
            }
        }
//        System.out.println(count);
        return count/2;
    }

    public static void main(String[] args) {
        String str[] = {"cd","ac","dc","ca","zz"};
        FindMaximumNumberofStringPairs obj = new FindMaximumNumberofStringPairs();
        ;
        System.out.println(obj.maximumNumberOfStringPairs(str));
    }
}
