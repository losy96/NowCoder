import java.util.ArrayList;

public class LastRemainingSolution {
    /**
     * 每次数到这个小孩就删除，继续开始数，这题很简单。
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining_Solution(int n, int m) {
        if (n==0){
            return -1;
        }
        ArrayList<Integer> children = new ArrayList<>();
        for (int i=0;i<n;i++){
            children.add(i);
        }
        int _continue = 0;
        while (children.size()>1){
            int childPlace = (_continue+m-1)%children.size();
            System.out.println(children.get(childPlace));
            children.remove(childPlace);
            _continue = childPlace;
        }
        return children.get(0);
    }
}
