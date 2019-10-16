import java.util.ArrayList;

public class ReverseList {
    public static ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null){
            nodes.add(head);
            head = head.next;
        }
        ListNode newHead = nodes.get(nodes.size() - 1);
        ListNode temp = newHead;
        for (int i = nodes.size()-2;i>=0;i--){
            temp.next = nodes.get(i);
            temp = temp.next;
        }
        temp.next = null;
        return newHead;
    }
}
