//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class BinaryTreeLevelOrderTraversalI {
//   static class TreeNode {
//        int val;
//        ConstructBinaryTreefromPreorderandInorderTraversal.TreeNode left;
//        ConstructBinaryTreefromPreorderandInorderTraversal.TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, ConstructBinaryTreefromPreorderandInorderTraversal.TreeNode left, ConstructBinaryTreefromPreorderandInorderTraversal.TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//
//   }
//
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        while (!q.isEmpty()){
//            TreeNode curr = q.remove();
//            if(curr==null){
//                if (q.isEmpty()) {
//                    break;
//                }
//                q.add(null);
//            }
//            else{
//                if (curr.left != null) {
//                    q.add(curr.left);
//                }
//            }
//        }
//    }
//
//
//    public static void main(String[] args) {
//
//    }
//}
