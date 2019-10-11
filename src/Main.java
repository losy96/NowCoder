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
        int[] pre = {2,3,4,5,6,1};
        int[] a = {6,7,8,8,9,9,10,10,22,23,24,25,26,27,28,29,32,33,43,54,2,3,4,5};
        int[] in = {4,2,1,5,3,6};
//        TreeNode root = ReConstructBinaryTree.reConstructBinaryTree(pre,in);
        System.out.println(MinNumberInRotateArray.minNumberInRotateArray(a));
    }
}
