import java.util.HashSet;

public class UnionAndIntersection {

    public int union(int arr1[],int arr2[]){
        HashSet<Integer> ans = new HashSet<>();
        for (int i : arr1) {
            ans.add(i);
        }
        for (int i : arr2) {
            ans.add(i);
        }
        System.out.println(ans);
        return ans.size();
    }

    public int Intersection(int arr1[],int arr2[]){
        HashSet<Integer> ans = new HashSet<>();
        for (int i : arr1) {
            ans.add(i);
        }
        int count = 0;
        for(int i : arr2) {
            if (ans.contains(i)) {
                count++;
                ans.remove(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        UnionAndIntersection obj = new UnionAndIntersection();
        System.out.println(obj.union(arr1,arr2));
        System.out.println(obj.Intersection(arr1,arr2));
    }
}
