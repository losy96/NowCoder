import java.util.Arrays;

public class Match {
    /**
     * 分析pattern
     * 对str进行处理
     * . 对匹配任意一个字符
     * * 前一个字符的任意次数 包括0
     * @param str
     * @param pattern
     * @return
     */
    public static boolean match(char[] str, char[] pattern) {
        //都为空
        if (str.length == 0 && pattern.length == 0){
            return true;
        }
        //str 不空  pattern空
        if (str.length != 0 && pattern.length == 0){
            return false;
        }
        //str 空  pattern不空
        if (str.length == 0 && pattern.length !=0){
            if (pattern.length>1){
                if (pattern[1] == '*'){
                    //选取patter从第三位到最后
                    return match(str, Arrays.copyOfRange(pattern,2,pattern.length));
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        //str不空  pattern不空
        if (str.length!=0&&pattern.length!=0){
            if (pattern.length==1){
                if (str[0] == pattern[0] || pattern[0] == '.'){
                    //继续截取之后进行匹配
                    return match(Arrays.copyOfRange(str,1,str.length),Arrays.copyOfRange(pattern,1,pattern.length));
                }else {
                    return false;
                }
            }else {
                if (pattern[1] == '*'){
                    //首字母匹配不成功
                    if (str[0] != pattern[0]&&pattern[0] !='.'){
                        return match(str,Arrays.copyOfRange(pattern,2,pattern.length));
                    }else {
                        //匹配成功
                        // aaaaaab   a*aaab 匹配
                        //str 向后匹配 即 *匹配多位
                        //pattern 向后匹配
                            //pattern 前两个为空，即*匹配0位
                            //pattern 前两个为空  str后移一位 即*匹配一位
                        //上述三个分支，每次递归都会分出三个分支，只要其中一个分支匹配成功，即成功
                        return match(Arrays.copyOfRange(str,1,str.length),pattern) || match(str,Arrays.copyOfRange(pattern,2,pattern.length)) || match(Arrays.copyOfRange(str,1,str.length),Arrays.copyOfRange(pattern,2,pattern.length));
                    }
                }else {
                    if (str[0] == pattern[0] || pattern[0] == '.'){
                        //继续截取之后进行匹配
                        return match(Arrays.copyOfRange(str,1,str.length),Arrays.copyOfRange(pattern,1,pattern.length));
                    }
                }
            }
        }
        return false;
    }
}
