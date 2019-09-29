import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Power.Power(2,-1));
//        TreeNode root  = new TreeNode(2);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//        ArrayList<Integer> anser = PrintFromTopToBottom.PrintFromTopToBottom(null);
//        for (int i:anser){
//            System.out.println(i);
//        }
        int[] pre = {1,2,4,3,5,6};
        int[] in = {4,2,1,5,3,6};
        TreeNode root = ReConstructBinaryTree.reConstructBinaryTree(pre,in);
        System.out.println(TreeDepth.TreeDepth(root));
    }
}
