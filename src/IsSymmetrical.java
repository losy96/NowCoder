import java.util.ArrayList;

public class IsSymmetrical {
    /**
     * 按层遍历，然后进行判断
     * !!!!!!!!!!是否可以通过不同遍历方式，先左后中再右，  先右后中再左  如果是镜像是不是应该相等
     *           如果用上面方法，是不是会出现漏洞，有可能不对称的子树 遍历出来结果也会相同。
     * @param pRoot
     * @return
     */
    public static boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null){
            return true;
        }else {
            ArrayList<TreeNode> father = new ArrayList<>();
            ArrayList<TreeNode> son = new ArrayList<>();
            //判断根节点的左右子节点是否为镜像
            if (twoNodesIsSymmetrical(pRoot,pRoot)){
                if (pRoot.left != null){
                    father.add(pRoot.left);
                    father.add(pRoot.right);
                }
            }else {
                return false;
            }
            while (father.size() > 0) {
                for (int i=0;i<father.size()/2;i++){
                    //如果不成镜像，就结束
                    if (!twoNodesIsSymmetrical(father.get(i),father.get(father.size()-1-i))){
                        return false;
                    }
                }
                //下层节点放入son
                son.clear();
                for (TreeNode i:father){
                    if (i.left != null){
                        son.add(i.left);
                    }
                    if (i.right != null){
                        son.add(i.right);
                    }
                }
                //下层节点作为father
                father.clear();
                for (TreeNode i:son){
                    father.add(i);
                }
            }
            return true;
        }
    }

    /**
     * 判断两个节点的子节点是否为镜像节点
     * @param a
     * @param b
     * @return
     */
    static boolean twoNodesIsSymmetrical(TreeNode a,TreeNode b){
        //a左 b右
        if (a.left == null && b.right == null){

        }else {
            if (a.left == null || b.right == null){
                return false;
            }else {
                if (a.left.val != b.right.val){
                    return false;
                }
            }
        }
        if (a.right == null && b.left == null){

        }else {
            if (a.right == null||b.left == null){
                return false;
            }else {
                if (a.right.val != b.left.val){
                    return false;
                }
            }
        }
        return true;
    }
}
