import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TreeNode pHead = new TreeNode(1);
        pHead.left = new TreeNode(1);
        pHead.right = new TreeNode(1);
        System.out.println(IsSymmetrical.isSymmetrical(pHead));
    }
}
