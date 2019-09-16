import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println(NumberOf1Between1AndN_Solution.NumberOf1Between1AndN_Solution(1));
//        sougou.
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        stackQueue.push(4);
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
    }
}
