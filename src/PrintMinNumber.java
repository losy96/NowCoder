import java.util.ArrayList;
import java.util.HashMap;

public class PrintMinNumber {
    /**
     * 重写排序，两个字符串进行拼接比较，小的拼接方式则成为两个字符串的相对位置排序规则。
     * 因为：两个字符串前后交换拼接，如：str1+str2 比 str2+str1小，
     *      意味着str1与str2的相对位置一定是str1在str2之前，中间无论是否加入其他数字，都不影响
     *      推广到所有元素相对位置，即是利用当前确定相对位置的方法进行重写排序规则。
     *      最后将排序好的元素按顺序拼接起来即可。
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers) {
        ArrayList<String> strNumbers = new ArrayList<>();
        //将数组中数值转化成string
        for (int i : numbers){
            strNumbers.add(Integer.toString(i));
        }
        for (int i=0;i<strNumbers.size();i++){
            for (int j=0;j<strNumbers.size()-i-1;j++){
                if (chooseMin(strNumbers.get(j+1),strNumbers.get(j))){
                    String temp = strNumbers.get(j);
                    strNumbers.set(j,strNumbers.get(j+1));
                    strNumbers.set(j+1,temp);
                }
            }
        }
        String anser = "";
        for (int i=strNumbers.size()-1;i>=0;i--){
            anser = anser+strNumbers.get(i);
        }
        return anser;
    }
    public static boolean chooseMin(String str1,String str2){
        //选出最小的，删除原先的两个，将最小的连接方式加入strNumbers
        String string1 = str1+str2;
        String string2 = str2+str1;
        if (string1.compareTo(string2)>0){
            return true;
        }else {
            return false;
        }
    }
}
