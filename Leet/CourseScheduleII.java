import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    public boolean isCycle(int[][] prerequisites,int n){
        boolean stack[] = new boolean[n];
        boolean vis[] = new boolean[n];

        for (int i = 0; i <n ; i++) {
            if (isCycleutile(prerequisites,i,stack,vis)) {
                return true;
            }
        }
        return false;
    }
    public boolean isCycleutile(int[][] prerequisites,int curr,boolean stack[],boolean vis[]){
        vis[curr] = true;
        stack[curr] =true;
        for (int i = 0; i < prerequisites.length ; i++) {
            if (prerequisites[i][1]==curr) {
                if (stack[prerequisites[i][0]]) {
                    return true;
                }
                else if (!vis[prerequisites[i][0]]&&isCycleutile(prerequisites, prerequisites[i][0], stack, vis)) {
                    return true;
                }
            }
        }
        stack[curr] =false;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indeg[] = new int[numCourses];

        for (int i = 0; i < prerequisites.length ; i++) {
            indeg[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean isCycle = isCycle(prerequisites,numCourses);
        if (isCycle) {
            System.out.println("Out from mid");
            return new int[0];
        }
        for (int i = 0; i <numCourses ; i++) {
            if (indeg[i] == 0) {
                System.out.println("In");
                q.add(i);
            }
        }

        int findorder[] = new int[numCourses];
        int idx =0;
        while (!q.isEmpty()){
            int curr = q.remove();
            for (int i = 0; i < prerequisites.length ; i++) {
                if (prerequisites[i][1] == curr) {
                    indeg[prerequisites[i][0]]--;
                    if (indeg[prerequisites[i][0]]==0) {
                        q.add(prerequisites[i][0]);
                    }
                }
            }
            System.out.println(curr);
            findorder[idx++] = curr;
        }
//        for (int i = 0; i < findorder.length; i++) {
//            System.out.print(findorder[i]+" ");
//        }
        return findorder;
    }





    public static void main(String[] args) {
        int prerequisites[][] = {
                {1,0},{2,0},{3,1},{3,2}
        };
        int numcourses = 4;
        CourseScheduleII obj = new CourseScheduleII();
        obj.findOrder(numcourses,prerequisites);
    }
}
