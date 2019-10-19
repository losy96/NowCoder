public class LeftRotateString {
    /**
     * 作弊解法
     * 正确做法
     * abcdefg  左旋三个
     * 即abc翻转得cba
     * defg翻转得gfed
     * 两者拼接得cbagfed
     * 整体翻转得结果defgabc
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str,int n) {
        if (str.length() == 0){
            return "";
        }
        if (n>=0){
            n = n%str.length();
        }else {
            //右移变成左移它的补
            n  = n%str.length();
            n = str.length()+n;
        }
        String leftSubString = str.substring(0,n);
        String rightSubString = str.substring(n);
        return rightSubString+leftSubString;
    }

    /**
     * 实现翻转函数
     * @param str
     * @return
     */
    public static String reverse(String str){
        double mid = (str.length()-1)*1.0/2;
        int start = 0;
        int end = str.length()-1;
        String leftStr = "";
        String rightStr = "";
        while (start<mid){
            //char交换
            leftStr = leftStr + String.valueOf(str.charAt(end));
            rightStr = String.valueOf(str.charAt(start))+rightStr;
            start ++;
            end --;
        }
        if (str.length()%2!=0){
            return leftStr+String.valueOf(str.charAt((int)mid))+rightStr;
        }else {
            return leftStr+rightStr;
        }

    }
}
