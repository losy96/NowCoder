public class StrToInt {
    public static int StrToInt(String str) {
        if (str.length() == 0) return 0;
        //包含字母，不合法
        if ((int)str.charAt(0) != (int)'-' &&str.charAt(0) != '+' && (str.charAt(0) <= '0'||'9' <= str.charAt(0))){
            //若第一个符号不是-+0-9
            return 0;
        }
        for (int i=1;i<str.length();i++){
            if (str.charAt(i) <= '0'||'9' <= str.charAt(i)){
                //若中间出现非数字
                return 0;
            }
        }
        //有+-号

        if (str.charAt(0)=='-') return ToInt(str.substring(1,str.length()))*-1;
        if (str.charAt(0)=='+') return ToInt(str.substring(1,str.length()));
        return ToInt(str);
    }
    public static int ToInt(String str){
        int anser = 0;
        for (int i = 0;i<str.length();i++){
            double num = Math.pow(10,str.length() -1 - i);
            anser = anser + ((int)str.charAt(i)-48)*(int)num;
        }
        return anser;
    }
}
