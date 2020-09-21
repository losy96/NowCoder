import java.util.Stack;

public class ReverseWord {
    /**
     *
     * @param str string字符串
     * @return string字符串
     */
    public static String reverseWord (String str) {
        // write code here
        String ans = "";
        Stack stack = new Stack();
        for (int i=0;i<str.length();i++){
            if ((int)str.charAt(i)<(int) 'A' || (int)'z' < (int)str.charAt(i)){
                while (!stack.empty()){
                    ans = ans + stack.pop();
                }
                ans = ans + str.charAt(i);
            }else {
                //压入
                stack.push(str.charAt(i));
            }
            if (i == str.length() -1){
                while (!stack.empty()){
                    ans = ans + stack.pop();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverseWord("Lihao lOPSAi. tasas!  asas"));
    }
}
