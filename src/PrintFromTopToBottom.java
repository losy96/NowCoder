import java.util.ArrayList;
public class PrintFromTopToBottom {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> anser = new ArrayList<>();
        if (root == null) return anser;
        ArrayList<TreeNode> father = new ArrayList<>();
        ArrayList<TreeNode> son = new ArrayList<>();
        father.add(root);
        while (father.size() != 0){
            for (TreeNode i : father){
                anser.add(i.val);//将遍历数据放入结果
                if (i.left != null){
                    son.add(i.left);
                }
                if (i.right != null){
                    son.add(i.right);
                }
            }
            father.clear();//清空父节点
            for (TreeNode i : son){//将子节点的数据装到父节点中，下次作父节点遍历
                father.add(i);
            }
            son.clear();
        }
        return anser;
    }
}
