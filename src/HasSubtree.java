import java.util.ArrayList;

public class HasSubtree {
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //空树
        if (root2 == null || root1 == null){
            return false;
        }else {
            //找出所有节点
            ArrayList<TreeNode> roots = new ArrayList<>();
            roots = findNode(root1, root2.val);
            for (TreeNode i : roots) {
                if (isSubTree(i, root2)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean isSubTree(TreeNode root1,TreeNode root2){
        /**
         * 对比子树
         */
        ArrayList<TreeNode> father1 = new ArrayList<>();
        father1.add(root1);
        ArrayList<TreeNode> father2 = new ArrayList<>();
        father2.add(root2);
        ArrayList<TreeNode> son1 = new ArrayList<>();
        ArrayList<TreeNode> son2 = new ArrayList<>();

        while (father2.size() != 0){
            for (int i=0;i<father1.size();i++){
                //如果都不是null
                if (father1.get(i).left!=null&&father2.get(i).left!=null){
                    if (father1.get(i).left.val == father2.get(i).left.val){
                        //左节点相同
                        son1.add(father1.get(i).left);
                        son2.add(father2.get(i).left);
                    }else {
                        return false;
                    }
                }else if (father2.get(i).left == null){
                    //子树结束
                }else {
                    return false;
                }

                if (father1.get(i).right!=null&&father2.get(i).right!=null){
                    if (father1.get(i).right.val == father2.get(i).right.val){
                        //左节点相同
                        son1.add(father1.get(i).right);
                        son2.add(father2.get(i).right);
                    }else {
                        return false;
                    }
                }else if (father2.get(i).right == null){
                    //子树结束
                }else {
                    return false;
                }

            }
            father1.clear();
            father2.clear();
            for (TreeNode i:son1){
                father1.add(i);
            }
            for (TreeNode i:son2){
                father2.add(i);
            }
            son1.clear();
            son2.clear();
        }

        return true;
    }

    public static ArrayList<TreeNode> findNode(TreeNode root1, int val){
        /**
         * 找到节点，如果不存在返回null
         * 将所有相同节点找出
         */
        ArrayList<TreeNode> results = new ArrayList<>();
        ArrayList<TreeNode> father = new ArrayList<>();
        father.add(root1);
        ArrayList<TreeNode> son = new ArrayList<>();
        while (father.size() != 0){
            for (TreeNode i : father){
                if (i.val == val){
                    results.add(i);
                }
                if (i.right != null) {
                    son.add(i.right);
                }
                if (i.left != null){
                    son.add(i.left);
                }
            }
            father.clear();
            for (TreeNode i : son){
                father.add(i);
            }
            son.clear();
        }
        return results;
    }
}
