import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        TreeNode root1  = new TreeNode(2);
//        root1.left = new TreeNode(3);
//        root1.right = new TreeNode(4);
//        root1.right.right = new TreeNode(5);
//        root1.left.left = new TreeNode(4);
//
//        TreeNode root2 = new TreeNode(3);
//        root1.left = new TreeNode(3);
//        root1.right = new TreeNode(4);
//        root1.right.right = new TreeNode(5);
////        root2.left.left = new TreeNode(4);
//
//        System.out.println(HasSubtree.HasSubtree(root1,root2));
//        ArrayList<TreeNode> anser = HasSubtree.findNode(root1,6);
//        for (TreeNode i:anser){
//            System.out.println(i.val);
//        }
        int[] a = {1,2,32,3,7,6,8};
        ReOrderArray.reOrderArray(a);
        for (int i: a){
            System.out.println(i);
        }
    }
}
