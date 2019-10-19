import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(1);
        pHead.next.next = new ListNode(2);
        pHead.next.next.next = new ListNode(3);
        pHead.next.next.next.next = new ListNode(3);
        pHead.next.next.next.next.next = new ListNode(3);
        pHead.next.next.next.next.next.next= new ListNode(5);
        pHead.next.next.next.next.next.next.next = new ListNode(5);
        pHead = DeleteDuplication.deleteDuplication(pHead);
        while (pHead != null){
            System.out.println(pHead.val);
            pHead = pHead.next;
        }
    }
}
