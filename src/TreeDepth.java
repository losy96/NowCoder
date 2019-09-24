import java.util.ArrayList;

public class TreeDepth {
    public static int TreeDepth(TreeNode root){
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        ArrayList<TreeNode> arrayListNext = new ArrayList<>();
        arrayList.add(root);
        int num=0;
        while (arrayList.size()!=0){
            for (int i=0;i<arrayList.size();i++){
                if (arrayList.get(i).left!=null) arrayListNext.add(arrayList.get(i).left);
                if (arrayList.get(i).right!=null) arrayListNext.add(arrayList.get(i).right);
            }
            arrayList.clear();
            for (TreeNode i:arrayListNext){
                arrayList.add(i);
            }
            arrayListNext.clear();
            num++;
        }
        return num;
    }
}
