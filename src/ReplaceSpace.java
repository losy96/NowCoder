public class ReplaceSpace {
    static public String replaceSpace(StringBuffer str) {
        for (int i = 0;i<str.length();i++){
            if (" ".equals(String.valueOf(str.charAt(i)))){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }
}
