import java.util.ArrayList;

public class Print {
    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> anser = new ArrayList<>();
        if (pRoot == null){
            return anser;
        }
        ArrayList<TreeNode> father = new ArrayList<>();
        ArrayList<TreeNode> son = new ArrayList<>();
        father.add(pRoot);
        while (father.size() > 0){
            ArrayList<Integer> col = new ArrayList<>();
            for (TreeNode i:father){
                col.add(i.val);
                if (i.left != null){
                    son.add(i.left);
                }
                if (i.right != null){
                    son.add(i.right);
                }
            }
            anser.add(col);
            father.clear();
            for (TreeNode i:son){
                father.add(i);
            }
            son.clear();
        }
        return anser;
    }
}
