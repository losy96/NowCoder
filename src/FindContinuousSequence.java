import java.util.ArrayList;

public class FindContinuousSequence {
    /**
     * 类似于双指针思路
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> anser = new ArrayList<>();
        int startNum = 1;
        int total = 0;
        for (int i = 1;i<sum;i++){
            total = total + i;
            if (total==sum){
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int j = startNum;j<=i;j++){
                    arrayList.add(j);
                }
                anser.add(arrayList);
            }else if (total>sum){
                while (total > sum){
                    total = total - startNum;
                    startNum ++;
                }
                if (total == sum){
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int j = startNum;j<=i;j++){
                        arrayList.add(j);
                    }
                    anser.add(arrayList);
                }
            }
        }
        return anser;
    }
}
