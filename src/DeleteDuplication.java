public class DeleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        if (pHead.next != null){
            //如果头节点重复删除
            if (pHead.val == pHead.next.val){
                //重新寻找头节点
                int k = pHead.val;
                while (pHead!=null&&pHead.val == k){
                    pHead = pHead.next;
                }
                return deleteDuplication(pHead);
            }else {
                //头节点不重复，将头节点下一个节点作为新的头节点传入当前方法
                //继续以传入的节点作为头节点判断头节点是否重复
                pHead.next = deleteDuplication(pHead.next);
                return pHead;
            }
        }
        return pHead;
    }
}
