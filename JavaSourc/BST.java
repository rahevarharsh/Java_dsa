import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
//    public static Node insert(Node root,int val){
//        if (root == null) {
//            root = new Node(val);
//            return root;
//        }
//        if (root.data > val) {
//            root.left = insert(root.left,val);
//        }
//        else{
//            root.right = insert(root.right,val);
//        }
//        return root;
//    }
static class info{
        boolean isBST;
        int size;
        int max;
        int min;
        info(boolean isBST,int size,int max,int min){
            this.isBST = isBST;
            this.size=size;
            this.max=max;
            this.min = min;
        }
}

    public static Node insert(Node root,int val){
        if (root == null) {
            Node newNode = new Node(val);
            return newNode;
        }
        if (root.data <val) {
          root.right = insert(root.right,val);
        }
        else{
           root.left= insert(root.left, val);
        }
        return root;
    }

    public static boolean search(Node root,int key){
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        else if (root.data > key) {
          return  search(root.left,key);
        }
        return search(root.right, key);
    }

    static void inorder(Node root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(" "+root.data+" ");
        inorder(root.right);
    }
    public static Node delete(Node root,int val){
        if (root == null) {
            return null;
        }
        if (root.data > val) {
           root.left= delete(root.left,val);
        }
        else if (root.data < val) {
            root.right = delete(root.right, val);
        }
        else if (root.data == val) {
            if (root.left==null&&root.right==null) {
                return null;
            }
            else if (root.right == null) {
                root = root.left;
            }
            else if (root.left == null) {
                root = root.right;
            }
            else{
              int isa =  inorderSucceser(root.right);
              delete(root,isa);
              root.data = isa;
            }
        }
        return root;
    }

    public static int inorderSucceser(Node root){
        while (root.left!=null){
            root = root.left;
        }
        return root.data;
    }

    public static void rangeNumber(Node root,int k1,int k2){
        if (root == null) {
            return;
        }
        if (root.data >= k1&&root.data<=k2) {
            rangeNumber(root.left,k1,k2);
            System.out.print(root.data+" ");
            rangeNumber(root.right, k1, k2);
        }
        else if (root.data >k2) {
            rangeNumber(root.left, k1, k2);
        }
        else{
            rangeNumber(root.right, k1, k2);
        }
    }
    static ArrayList<Integer> path = new ArrayList<>();
    public static void RootToLeaf(Node root){
        if (root == null) {
            return;
        }
        if (root.left == null && root.right==null) {
            path.add(root.data);
            System.out.println(path);
            path.remove(path.size()-1);
            return;
        }
        path.add(root.data);
        RootToLeaf(root.left);
        RootToLeaf(root.right);
        path.remove(path.size()-1);
}
  public static boolean isValidBst(Node root,Node max,Node min){
       if (root == null) {
           return true;
       }
      if (max!=null && root.data>=max.data) {
          return false;
      }
      if (min!=null && root.data<=min.data) {
          return false;
      }
     return isValidBst(root.left, root, min)&&isValidBst(root.right,max,root);
   }


   public static Node creatBalanceBTS(int arr[],Node root,int i,int j){
       if (i > j ) {
        return null;
       }
       int mid = (i+j)/2;
       System.out.println("i :"+i+" J :"+j+" mid :"+mid);
        root = new Node(arr[mid]);
        root.left=creatBalanceBTS(arr,root.left,i,mid-1);
        root.right=creatBalanceBTS(arr, root.right, mid+1, j);
       return root;
   }

   public static Node Mirroer(Node root){
       if (root == null) {
           return null;
       }
       if (root.right == null && root.left==null) {
           return root;
       }
      Node temp = Mirroer(root.left);
       root.left= Mirroer(root.right);
       root.right = temp;
       return root;
   }

  public static void levelOrder(Node root){
      Queue<Node> tree = new LinkedList<>();
      tree.add(root);
      tree.add(null);
      while (true){
          Node curr = tree.remove();
          if (curr == null) {
              if (tree.isEmpty()) {
                  break;
              }
              else{
                  System.out.println();
                  tree.add(null);
              }
          }
          else{
              System.out.print(curr.data+" ");
              if (curr.left != null) {
                  tree.add(curr.left);
              }
              if (curr.right != null) {
                  tree.add(curr.right);
              }

          }
      }
   }
static int maxSize;
   public static info logestBST(Node root){
       if (root == null) {
           return new info(true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
       }
       if (root.left == null&&root.right==null) {
            return new info(true,1,root.data,root.data);
       }
       info leftTree = logestBST(root.left);
       info rightTree = logestBST(root.right);
       boolean bstStatus = false;
       if (rightTree.isBST&&leftTree.isBST) {
           if (leftTree.max<root.data &&rightTree.min>root.data) {
               bstStatus = true;
           }
       }
       int minINfo = Integer.min(root.data, Integer.min(rightTree.min,leftTree.min));
       int maxINfo = Integer.max(root.data,Integer.max(rightTree.max, leftTree.max));
       info reInfo = new info(bstStatus,rightTree.size+ leftTree.size+1,maxINfo,minINfo);
       if (reInfo.isBST) {
          maxSize= Integer.max(maxSize, reInfo.size);
       }
       return reInfo;
   }

    public static void main(String[] args) {

//           5
//        /   \
//       2     9
//     /  \   /
//    1   4  7
//        /   \
//       3     8

        int arr[] = {5,2,4,1,3,9,7,8};
        Node root=null;
        for(int d:arr){root =  insert(root,d);}
        inorder(root);
//        System.out.println(search(root,3));
        System.out.println();

//      ******************** Delete Node **************************
//                    inorder(root);
//                    delete(root,4);
//                    inorder(root);
//      ***********************************************************
//      ********************* Range NUMBER ************************
//        rangeNumber(root,3,7);
//      ***********************************************************
//        RootToLeaf( root);
//        ***********************************************************
//        Node root2 = new Node(3);
//        root2.left = new Node(2);
//        root2.right = new Node(5);
//        root2.left.right = new Node(4);
//        System.out.println(isValidBst(root2,null,null));
//        inorder(root2);
//        System.out.println();
//        Mirroer(root2);
//        inorder(root2);
//        ***********************************************************
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        Node newRoot = null;
        newRoot = creatBalanceBTS(arr1,newRoot,0,arr1.length-1);
//        System.out.println(newRoot.data);
//        levelOrder(newRoot);
//        System.out.println();
//     inorder(newRoot);
//
        Node TestRoot = new Node(50);
        TestRoot.left = new Node(30);
        TestRoot.left.left = new Node(5);
        TestRoot.left.right = new Node(20);

        TestRoot.right = new Node(60);
        TestRoot.right.left = new Node(45);
        TestRoot.right.right = new Node(70);
        TestRoot.right.right.right = new Node(80);
        TestRoot.right.right.left = new Node(65);
        logestBST(TestRoot);
        System.out.println(maxSize);
    }
}
