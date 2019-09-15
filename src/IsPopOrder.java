import java.util.Stack;

public class IsPopOrder {
    /**
     * pushA压栈，每次压栈都进行匹配，若符合popA则弹出，否则继续压栈
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        //全部入栈
        int j = 0;
        for (int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            if (stack.peek() == popA[j]){
                stack.pop();
                j++;
                while (!stack.empty()){
                    if (stack.peek() == popA[j]){
                        stack.pop();
                        j++;
                    }else {
                        break;
                    }
                }
            }
        }
        if (stack.empty()){
            return true;
        }else {
            return false;
        }
    }
}
