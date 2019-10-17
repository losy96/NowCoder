import java.util.ArrayList;
import java.util.HashSet;

public class Permutation {
    /**
     * 使用递归的方法进行求解，去掉首字母的余下字符串的排列。
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> anser = all(str);
        HashSet<String> hashSet = new HashSet<>();
        for (int i=0;i<anser.size();i++){
            if (hashSet.contains(anser.get(i))){
                anser.remove(i);
                i--;
            }else {
                hashSet.add(anser.get(i));
            }
        }
        return anser;
    }
    public static ArrayList<String> all(String str) {
        ArrayList<String> anser = new ArrayList<>();
        if (str.length() == 1){//退出条件
            anser.add(str);
            return anser;
        }
        for (int i=0;i<str.length();i++){
            //获取首字符
            char firstChar = str.charAt(i);
            String newString = str.substring(0,i)+str.substring(i+1);
            //获取除去第一个字符串的所有结果
            ArrayList<String> temp = all(newString);
            for (String j:temp){
                //取得的结果加上首字符，存到当前递归结果中。
                anser.add(firstChar+j);
            }
        }
        return anser;
    }
}
