import java.util.Arrays;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

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


    public static int findIndex(int[] array, int target,int start,int end) {
        if (array == null)
            return -1;

        for (int i = start; i < end+1; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    static int curr=0;
    public TreeNode halper(int arr[],int preorder[],int start,int end){

        if(start>end){
            System.out.println();
            return null;
        }
        System.out.println(start+" "+end);
        int val =preorder[curr];
        curr++;
        TreeNode n = new TreeNode(val);
        if (start == end) {
            return n;
        }

        int pos = findIndex(arr,val, start,end);
        n.left = halper(arr,preorder,start,pos-1);
        n.right = halper(arr, preorder, pos+1, end);
        return n;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       TreeNode node = halper(inorder,preorder,0,inorder.length-1);
        return node;
    }

    public void printNode(TreeNode root){
        if (root == null) {
            System.out.print(" Null ");
            return;
        }
        System.out.println(root.val);
        printNode(root.left);
        printNode(root.right);
    }
    
    public static void main(String[] args) {
        int pre[] ={1,2,3,4,5,6};
        int ino[]={3,2,4,1,6,5};
        ConstructBinaryTreefromPreorderandInorderTraversal obj = new ConstructBinaryTreefromPreorderandInorderTraversal();
        obj.buildTree(pre,ino);
    }
}

//class Solution {
//    private int i = 0;
//    private int p = 0;
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return build(preorder, inorder, Integer.MIN_VALUE);
//    }

//    private TreeNode build(int[] preorder, int[] inorder, int stop) {
//        if (p >= preorder.length) {
//            return null;
//        }
//        if (inorder[i] == stop) {
//            ++i;
//            return null;
//        }
//
//        TreeNode node = new TreeNode(preorder[p++]);
//        node.left = build(preorder, inorder, node.val);
//        node.right = build(preorder, inorder, stop);
//        return node;
//    }
//}