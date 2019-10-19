public class DeleteDuplication {
    /**
     * 两种情况：
     *     若头节点为重复节点，删除重复的节点，选择第一个不重复的节点作为头节点，返回。
     *     若头节点不重复，将头节点单独拿出，以第二个节点作为头节点，重复上述步骤。
     *     最后将递归返回节点连接起来，即是答案。
     * @param pHead
     * @return
     */
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
