public class ReConstructBinaryTree {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //都有
        //左为空
        //右为空
        TreeNode subRoot = new TreeNode(pre[0]);//先序遍历的第一个
        //只有一个节点
        if (pre.length==1){
            return new TreeNode(pre[0]);
        }else if (pre.length == 0){
            return null;
        }else if (pre.length > 0){
            int splitIn=0;
            //找到中序遍历的分割点
            for (int i=0;i<in.length;i++){
                if (in[i] == pre[0]){
                    splitIn = i;
                    break;
                }
            }
            int[] leftIn = SubArray(in,0,splitIn);
            int[] rightIn = SubArray(in,splitIn+1,in.length);

            //前序遍历分割
            int splitPre = findSplitPreNum(leftIn,pre);
            int[] leftPre = SubArray(pre,1,splitPre);
            int[] rightPre = SubArray(pre,splitPre,pre.length);
            if (leftIn.length>0){
                subRoot.left = reConstructBinaryTree(leftPre,leftIn);
            }
            if (rightIn.length>0){
                subRoot.right = reConstructBinaryTree(rightPre,rightIn);
            }
        }
        return subRoot;
    }
    public static int[] SubArray(int[] array,int start,int end){
        if (start>=array.length){
            return new int[0];
        }
        if (end>=array.length){
            end = array.length;
        }
        int [] subArray = new int[end - start];
        int j=0;
        for (int i=start;i<end;i++){
            subArray[j] = array[i];
            j++;
        }
        return subArray;
    }
    public static int findSplitPreNum(int[] subIn,int[] pre){
        int max = 0;
        for (int i=0;i<subIn.length;i++){
            for (int j=0;j<pre.length;j++){
                if (pre[j] == subIn[i]){
                    if (j>max){
                        max = j;
                    }
                }
            }
        }
        return max+1;
    }
}
