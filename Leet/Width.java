import java.util.*;

public class Width {



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }






   static int idx = -1;
    public TreeNode makeTree(int arr[]){
        idx++;
        if (arr[idx] ==-1 ) {
            return null;
        }
        TreeNode root = new TreeNode(arr[idx]);
        root.left = makeTree(arr);
        root.right = makeTree(arr);
        return root;
    }

    static class Pair{
        int idx;
        TreeNode curr;
        Pair(TreeNode curr,int idx){
            this.idx = idx;
            this.curr = curr;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int maxWidth = 0;
        while (!q.isEmpty()){
            int size = q.size();
            int maxbound = Integer.MIN_VALUE;
            int minbound = Integer.MAX_VALUE;
            for (int i = 0; i <size ; i++) {
                Pair curr = q.remove();
                TreeNode node = curr.curr;
                int idx = curr.idx;
                maxbound = Math.max(maxbound,idx);
                minbound = Math.min(minbound,idx);
                if (node.left != null) {
                    q.add(new Pair(node.left,2*idx));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right,2*idx+1));
                }
            }
            maxWidth = Integer.max(maxWidth,maxbound-minbound+1);
        }
        return maxWidth;
    }



    public static void main(String[] args) {
//        int arr[]= {1,3,5,6,-1,-1,-1,-1,2,-1,9,7,-1,-1,-1};
        int arr[]= {1,3,5,-1,-1,-1,2,-1,-1};
      ;
        Width obj = new Width();
        TreeNode root =obj.makeTree(arr);
//        System.out.println(root.val+" "+ root.left.val+" "+ root.left.left.val);
        ;
        System.out.println(obj.widthOfBinaryTree(root));
    }
}
