import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ListNode pHead = new ListNode(2);
        pHead.next = new ListNode(4);
        pHead.next.next = new ListNode(6);
        pHead.next.next.next = new ListNode(9);
        pHead.next.next.next.next = new ListNode(10);
        pHead.next.next.next.next.next = pHead.next;
        System.out.println(EntryNodeOfLoop.EntryNodeOfLoop(pHead).val);
    }
}
