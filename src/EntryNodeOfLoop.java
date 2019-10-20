public class EntryNodeOfLoop {
    /**
     * 1、判断是否成环，速度不同的指针相遇，则说明成环，记录下当前相遇位置。(慢指针每次走一步，快指针每次走两步)
     * 2、若成环:
     *      设链表起始点为a点，入口点为b点，环内相遇点为c点。
     *      直到相遇，快指针走的距离为：ab+bc+k(bc+cb)  慢指针走的距离为:ab+bc (一旦慢指针进入环内，两个指针必定在一圈之内相遇)
     *      同样时间内，快指针比慢指针多走2倍的路程所以有等式：2(ab+bc) = ab+bc+k(bc+cb)
     *      上式推导结果=> ab = (k-1)bc + kcb => ab = (k-1)(bc+cb) + cb
     *      即ab长度为cb长度加上k-1圈环的长度，（因为k-1>=0）
     *      因此如果两个一样快的指针，一个从起始点走一个从相遇点走，他们一定会相遇在入口点。
     * @param pHead
     * @return
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        //若起始点开始即是环，起始点即会是相遇点，第二步刚开始，两个指针即会相遇，即会返回值，可以处理。
        if (pHead == null){
            return null;
        }
        ListNode meet = isCircle(pHead);
        if (meet == null){
            return null;
        }else {
            ListNode startPiont = pHead;
            while (meet != startPiont){
                startPiont = startPiont.next;
                meet = meet.next;
            }
            return meet;
        }
    }
    public static ListNode isCircle(ListNode pHead){
        //判断成环
        if (pHead.next == null){
            return null;
        }else if (pHead.next.next==null){
            return null;
        }else {
            ListNode slowPoint = pHead.next;
            ListNode fastPoint = pHead.next.next;
            while (fastPoint!=null){
                if (fastPoint == slowPoint){
                    return fastPoint;
                }
                slowPoint = slowPoint.next;
                if (fastPoint.next!=null){
                    fastPoint = fastPoint.next.next;
                }else {
                    return null;
                }
            }
            return null;
        }
    }
}