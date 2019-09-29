import java.util.Stack;

public class StackMin {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 使用辅助栈，将小于等于最小栈栈顶的元素压入最小栈，这样就实现了栈里现有元素中最小元素 放入了最小栈
     * @param node
     */
    public void push(int node) {
        if (minStack.empty()){
            minStack.push(node);
        }else if (minStack.peek()>=node){
            minStack.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if (minStack.peek() == stack.peek()){
            stack.pop();
            minStack.pop();
        }else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
