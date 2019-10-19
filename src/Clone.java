public class Clone {
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }
        //复制主线节点
        RandomListNode tempNode = pHead;
        while (tempNode != null){
            RandomListNode temp = new RandomListNode(tempNode.label);
            temp.next = tempNode.next;
            tempNode.next = temp;
            tempNode = temp.next;
        }
        tempNode = pHead;
        //处理特殊节点
        while (tempNode != null){
            //要拆开的节点
            if (tempNode.random!=null){
                tempNode.next.random = tempNode.random.next;
            }
            tempNode = tempNode.next.next;
        }

        //将链表拆分
        RandomListNode head = pHead.next;
        RandomListNode tempHead = pHead;
        tempNode = pHead.next;
        while (tempNode.next != null){
            tempHead.next = tempHead.next.next;
            tempHead = tempHead.next;
            tempNode.next = tempNode.next.next;
            tempNode = tempNode.next;
        }
        tempHead.next = null;
        return head;
    }
}
