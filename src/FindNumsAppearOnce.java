import java.util.HashMap;
import java.util.Set;

public class FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i:array){
             Integer temp = hashMap.get(i);
             if (temp == null){
                 hashMap.put(i,1);
             }else {
                 hashMap.put(i,temp+1);
             }
        }
        Set<Integer> temp = hashMap.keySet();
        for (int i:temp){
            if (hashMap.get(i) == 1){
                if (num1[0] == 0){
                    num1[0] = i;
                }else {
                    num2[0] = i;
                }
            }
        }
    }
}
