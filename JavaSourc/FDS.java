import java.util.HashMap;
import java.util.Map;

class NonRepeating {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 4, -4, 1, 3, 2};
        int firstNonRepeating = findFirstNonRepeatingElement(arr);

        if (firstNonRepeating != -1) {
            System.out.println("First non-repeating element: " + firstNonRepeating);
        } else {
            System.out.println("No non-repeating element found.");
        }
    }

    public static int findFirstNonRepeatingElement(int[] arr) {
        Map<Integer, Integer> elementCount = new HashMap<>();

        for (int element : arr) {
            elementCount.put(element, elementCount.getOrDefault(element, 0) + 1);
        }
        System.out.println(elementCount);
        for (int element : arr) {
            System.out.println((elementCount.get(element) == 1));
            if (elementCount.get(element) == 1) {
                return element;
            }
        }

        return -1;
    }
}
