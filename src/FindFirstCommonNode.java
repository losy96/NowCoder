import java.util.HashSet;

public class FindFirstCommonNode {
    /**
     * 遍历第一个链表 将节点放到集合
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> p1 = new HashSet<>();
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        while (temp1 != null){
            p1.add(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null){
            if (p1.contains(temp2)){
                return temp2;
            }else {
                temp2 = temp2.next;
            }
        }
        return null;
    }
    /**
     * 另一种
     * 当出现了第一个公用节点后，公用节点后面的链表就是两个链表的公共尾部了
     *          q-w--e-5-6-7
     * a-s-d-f-g-h-j-k-5-6-7
     *
     * 1、长的链表先走两个链表的长度差
     * 2、接下来剩下了的一起走，就一定能发现相同的节点
     */
    public ListNode _FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        while (temp1 != null){
            ++len1;
            temp1 = temp1.next;
        }
        while (temp2 != null){
            ++len2;
            temp2 = temp2.next;
        }
        temp1 = pHead1;
        temp2 = pHead2;
        int step ;
        if (len1>len2){
            step = len1-len2;
            for (int i=0;i<step;i++){
                temp1 = temp1.next;
            }
        }else {
            step = len2 - len1;
            for (int i=0;i<step;i++){
                temp2 = temp2.next;
            }
        }

        //共同进行
        while (temp1 != null){
            if (temp1 == temp2){
                return temp1;
            }else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return null;
    }
}
