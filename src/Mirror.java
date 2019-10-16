import java.util.ArrayList;

public class Mirror {
    public static void Mirror(TreeNode root) {
        ArrayList<TreeNode> fathers = new ArrayList<>();
        ArrayList<TreeNode> sons = new ArrayList<>();
        if (root != null){
            fathers.add(root);
            while (fathers.size()!=0){
                for (TreeNode temp : fathers){
                    //拿到子树
                    if (temp.left!=null){
                        sons.add(temp.left);
                    }
                    if (temp.right!=null){
                        sons.add(temp.right);
                    }
                    //交换左右子树
                    TreeNode change = temp.left;
                    temp.left = temp.right;
                    temp.right = change;
                }
                fathers.clear();
                for (TreeNode temp:sons){
                    fathers.add(temp);
                }
                sons.clear();
            }
        }
    }
}
