public class FindKthToTail {
    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode tempHead = head;
        int listLong = 0;
        while (tempHead != null){
            listLong++;
            tempHead = tempHead.next;
        }
        tempHead = head;
        if (k>listLong){
            return null;
        }
        for (int i=0;i<listLong-k;i++){
            tempHead = tempHead.next;
        }
        return tempHead;
    }
}
