public class PatternStr {
    public static void main(String[] args) {
        String s = "03234234324324324";
        //开始匹配
        int startIndex = 0;
        int endIndex = 0;
        while (endIndex < s.length()){
            if (s.indexOf(startIndex) == '0'){
                //符合090 0990
                endIndex = startIndex + 3;
                if (endIndex < s.length()){
                    String subStr = s.substring(startIndex,endIndex);
                    if (subStr.equals("0990")){
                        //执行相应动作
                        //回溯找到0
                        for (int i=startIndex;startIndex>=0;startIndex--){
                            if (s.indexOf(i) == '0'){
                                //去掉00之间的
                                String firstStr = s.substring(0,i);
                                String endStr = s.substring(startIndex-1,s.length());
                                s = firstStr+endStr;
                                startIndex = i;
                            }
                        }
                    }else {
                        subStr = s.substring(startIndex,endIndex-1);
                        if (subStr.equals("090")){
                            //执行相应动作
                            String firstStr = s.substring(0,startIndex);
                            String endStr = s.substring(endIndex+1,s.length());
                            s = firstStr+"0"+endStr;
                            startIndex++;
                        }
                    }
                }
            }
        }
        //统计最终字符串的0
        if (s.length() <= 1){
            System.out.println(s);
        }else {
            for (int i=0;i<s.length();i++){
                if (s.indexOf(i) == '0'){
                    //将字符串末尾的0去掉
                    endIndex = s.length()-1;
                    startIndex = s.length()-1;
                    if (s.indexOf(endIndex) == '0'){
                        //回头找0
                        while (startIndex > 0){
                            if (s.indexOf(startIndex) != '0'){
                                break;
                            }else {
                                startIndex--;
                            }
                        }
                    }
                    break;
                }
            }
            String firstStr = s.substring(0,startIndex);
            System.out.println(firstStr);
        }
    }
}
