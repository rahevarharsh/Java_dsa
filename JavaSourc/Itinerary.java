import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Itinerary {
    public static void main(String[] args) {
        HashMap<String,String> way = new HashMap<>();
        way.put("mumbai","delhi");
        way.put("delhi","goa");
        way.put("goa","chennai");
        way.put("chennai","bengluru");
        Set<String> keys= way.keySet();
        HashMap<String,String> reway = new HashMap<>();
        for (String key:keys) {
            reway.put(way.get(key),key);
        }
        Set<String> temp = new HashSet<>(keys);
        String strat="";
        for (String key:keys) {
            if (!reway.containsKey(key)) {
               strat = key;
            }
        }
        StringBuilder path = new StringBuilder("");
        path.append(strat);
        while (way.containsKey(strat)){
            path.append(" --> "+way.get(strat));
            strat = way.get(strat);
        }
        System.out.println(path);
    }
}
