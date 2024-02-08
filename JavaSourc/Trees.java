import java.util.*;

public class Trees {
    public static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
     static class Tree{
        static int idx = -1;
        Node buildTree(int arr[]){
            ++idx;
            if (arr[idx] == -1) {
                return null;
            }
            Node newNode = new Node(arr[idx]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }
        int treeHight(Node root){
            if (root == null) {
                return 0;
            }
            int lh = treeHight(root.right);
            int rh = treeHight(root.left);
            return Integer.max(lh,rh)+1;
        }


        int leftrightSum(Node root){
            if (root == null) {
                return 0;
            }
            return root.data+ leftrightSum(root.left)+leftrightSum(root.right);
        }

        void TranformTosum(Node root){
            if (root == null) {
                return ;
            }
            int lsum = leftrightSum(root.left);
            int rsum = leftrightSum(root.right);
            root.data = lsum+rsum;
            TranformTosum(root.left);
            TranformTosum(root.right);
        }

        int KthAncister(Node root,int n,int k){
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 1;
            }
            int lhs = KthAncister(root.left,n,k);
            int rhs = KthAncister(root.right,n,k);
            if (rhs == k||lhs == k) {
                System.out.println(root.data);
                return k+1;
            }
           else if (rhs == -1&&lhs==-1) {
                return -1;
            }
            else if (rhs==-1){
                return lhs+1;
            }
            return rhs+1;
        }

        Node lca(Node root,int n1,int n2){
            if (root==null||root.data == n1 || root.data ==n2) {
                return root;
            }
            Node lhs = lca(root.left,n1,n2);
            Node rhs = lca(root.right,n1,n2);

            if (lhs== null && rhs==null) {
                return null;
            }
            if (lhs == null) {
                return rhs;
            }
            else  if(rhs == null){
                return lhs;
            }
            return root;
        }

        int distance(Node root,int n){
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int disleft = distance(root.left,n);
            int disright = distance(root.right,n);

            if (disleft >=0) {
                return disleft+1;
            }
            else if (disright>=0){
                return disright+1;
            }

            return -1;
        }

        int getDistance(Node root,int n1,int n2){
            if (root == null) {
                return 0;
            }
            Node lca = lca(root,n1,n2);
            int n1dis = distance(lca,n1);
            int n2dis = distance(lca,n2);
            return n1dis+n2dis;
        }

        Boolean getPath(Node root,int n,ArrayList<Node> l){
            if (root == null) {
                return false;
            }
            l.add(root);
            if (root.data==n) {
               return true;
            }
//            System.out.println(l);
            if (getPath(root.left,n,l)||getPath(root.right,n,l)) {

                return true;
            }
            l.remove(l.size()-1);
            return false;
        }

        Node commanAncister(Node root,int n1,int n2){
            ArrayList<Node> l1 = new ArrayList<>();
            ArrayList<Node> l2 = new ArrayList<>();

            getPath(root,n1,l1);
            getPath(root,n2,l2);
            System.out.println();
            for (int i = 0; i < l1.size() ; i++) {
                System.out.print(l1.get(i).data+" ");
            }
            System.out.println();
            for (int i = 0; i < l2.size() ; i++) {
                System.out.print(l2.get(i).data+" ");
            }
            System.out.println();
            int i=0;
            for (; i < l1.size() ; i++) {
                if (l1.get(i).data!= l2.get(i).data) {
                    break;
                }
            }
            return l1.get(i-1);
        }



        boolean isIdentical(Node root,Node subRoot){
            if (root == null && subRoot == null) {
//                System.out.println("root == null && subRoot == null");
                return true;
            }
            else if (root == null || subRoot ==null ) {
//                System.out.println("root == null || subRoot ==null");
                return false;
            }
            else if (root.data!=subRoot.data) {
//                System.out.println("root.data!=subRoot.data");
                return false;
            }
            if (!isIdentical(root.left,subRoot.left)) {
//                System.out.println("con1");
                return false;
            }
            if (!isIdentical(root.right,subRoot.right)) {
//                System.out.println("con2");
                return false;
            }
//            System.out.println("IN base!");
            return true;
        }


        boolean subTree(Node root,Node subRoot){
            if (root==null){
                return false;
            }
            if (root.data == subRoot.data) {
                if (isIdentical(root,subRoot)) {
                    return true;
                }
            }
            return subTree(root.left,subRoot)||subTree(root.right,subRoot);
        }
        Map<Integer,Integer> view = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        static class Info{
            int position;
            Node n;
            Info(int pos,Node s){
                position = pos;
                n= s;
            }
        }

        void KthLevel(Node root,int curr,int k){
            if (root == null) {
                return;
            }
            if (curr == k) {
                System.out.print(root.data+" ");
                return;
            }
            KthLevel(root.left,curr+1,k);
            KthLevel(root.right,curr+1,k);
        }


        void TopView(Node root){
            Queue<Info> level = new LinkedList<>();
            level.add( new Info(0,root) );
            level.add(null);
            while (!level.isEmpty()){
                Info currInfo = level.remove();

                if (currInfo==null) {
                    if (level.isEmpty()) {
                        break;
                    }
                    else{
                        level.add(null);
                    }
                }
                else{
                    Node curr = currInfo.n;
                    int pos = currInfo.position;
                    if (!view.containsKey(pos)){
                        view.put(pos, curr.data);
                    }
                    min = Math.min(min,pos);
                    max = Math.max(max,pos);
                    if (curr.left != null) {
                        level.add(new Info(pos-1,curr.left) );
                    }
                    if (curr.right != null) {
                        level.add( new Info(pos+1,curr.right));
                    }
                }
            }

        }

        void levelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()){
                Node currNode = q.remove();
                if (currNode==null){
                    if (q.isEmpty()) {
                        break;
                    }else{
                        System.out.println();
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+"  ");
                    if (currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if (currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        ArrayList<Integer> ls = new ArrayList<>();
        void halper(Node root){
            if(root==null){
                return;
            }
            halper(root.left);
            ls.add(root.data);
            halper(root.right);
        }
        public List<Integer> inorderTraversal(Node root) {
            halper(root);
            return ls;
        }


        int sumOfNodes(Node root){
            if (root == null) {
                return 0;
            }
            int ls = sumOfNodes(root.left);
            int rs = sumOfNodes(root.right);
            return ls+rs+ root.data;
        }
        int Diameter(Node root){
            if (root==null){
                return 0;
            }
            int lh=treeHight(root.left);
            int rh= treeHight(root.right);
            int ld = Diameter(root.left);
            int rd = Diameter(root.right);

            int maxDiameter=Math.max(ld,rd);
            return Math.max(maxDiameter,lh+rh+1);
        }
        static class Info2{
            int diameter;
            int height;
            Info2(int d,int h){
                height = h;
                diameter = d;
            }

        }

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
//           1
//        /    \
//       2      5
//      / \     /
//     3   4   6
//    /     \
//   11     12
//     \     \
//      14    13
        int arr[]= {1,2,3,11,-1,14,-1,-1,-1,4,-1,12,-1,13,-1,-1,5,6,-1,-1,-1};
//        int arr[]= {1,2,3,-1,-1,4,-1,-1,5,6,-1,-1,-1};
//        **********************************************************************************
        Node root = tree.buildTree(arr);
//        **********************************************************************************
//        System.out.println(root.data);
//        **********************************************************************************
//        tree.levelOrder(root);
//        **********************************************************************************
//        System.out.println(tree.treeHight(root));
//        **********************************************************************************
//        System.out.println(tree.sumOfNodes(root));
//        **********************************************************************************
//        System.out.println(tree.Diameter(root));
//        **********************************************************************************
//        List<Integer> s=tree.inorderTraversal(root);
//        System.out.println(s);
        int arr1[]={5,6-1,-1,-1};
        Node subRoot = new Node(5);
        Node newNode = new Node(6);
        subRoot.left = newNode;
        //        **********************************************************************************
//        System.out.println(subRoot.left.data);
//        System.out.println(tree.subTree(root,subRoot));
//        **********************************************************************************
//        tree.TopView(root);
//        for (int i = tree.min; i <= tree.max ; i++) {
//            System.out.print(tree.view.get(i)+" ");
//        }
//        System.out.println();
//        **********************************************************************************
//        tree.KthLevel(root,1,2);
//        **********************************************************************************
        System.out.println();
//       ********************* METHODE 1 FOR COMMAN ANCISTERS******************************
//        Node comman =  tree.commanAncister(root,11,12);
//        System.out.println(comman.data);
//        *********************************************************************************
//        **************************METHODE 2 FOR COMMAN ANCISTER**************************
//       Node s = tree.lca(root,14,13);
//        System.out.println(s.data);
//        **************************EDGE DISTANCE BETWEEN TWO NODE***************************
//        System.out.println(tree.getDistance(root,11,12));
//        System.out.println(tree.KthAncister(root,14,1));
        tree.levelOrder(root);
        System.out.println();
        tree.TranformTosum(root);
        System.out.println();
        tree.levelOrder(root);
    }

}
