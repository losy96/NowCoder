import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println(NumberOf1Between1AndN_Solution.NumberOf1Between1AndN_Solution(1));
//        sougou.
//        System.out.println(ReversalNum.ReversalNum(1134423449));
//        NumberOf1.NumberOf1(-3);
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(4);
        root.left = new TreeNode(1);
        System.out.println(TreeDepth.TreeDepth(root));
    }
}
