import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TreeNode pHead = new TreeNode(1);
        pHead.left = new TreeNode(2);
        pHead.right = new TreeNode(3);
        pHead.left.right = new TreeNode(4);
        pHead.right.left = new TreeNode(5);
        pHead.right.right = new TreeNode(6);
        ArrayList<ArrayList<Integer>> a = Print.Print(pHead);
        for (ArrayList<Integer> i:a){
            for (Integer j:i){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
