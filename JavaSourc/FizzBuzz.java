import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {



    public String halper(int n){
         StringBuilder out = new StringBuilder("");
        if (n%3 == 0) out.append("Fizz");

        if (n%5 == 0) out.append("Buzz");

        if (out.toString()=="") return String.valueOf(n);

        return out.toString();
    }

    public List<String> fizzBuzz(int n) {
        List<String> al = new ArrayList<>();
        for(int i=1;i<=n;i++){
            al.add(halper(i));
        }
        return al;
    }

    public static void main(String[] args) {

    }
}
