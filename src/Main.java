import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.random = head.next.next.next;
        RandomListNode pHead = Clone.Clone(head);
//        RandomListNode pHead = head;
        while (pHead != null){
            System.out.println(pHead.label);
            if (pHead.random != null){
                System.out.println("11111");
                System.out.println(pHead.random.label);
            }
            pHead = pHead.next;
        }
    }
}
