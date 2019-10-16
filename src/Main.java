import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(7);
        head1.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next = new ListNode(10);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(7);
        head2.next.next.next = new ListNode(7);
        head2.next.next.next.next = new ListNode(13);
        head2.next.next.next.next.next = new ListNode(19);

        ListNode head3 = ReverseList.ReverseList(head1);

        while (head3 != null){
            System.out.println(head3.val);
            head3 = head3.next;
        }
    }
}
