public class Merge {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null || list2 == null){
            //返回不是空的
            //如果都是空的，返回空
            if (list1 != null){
                return list1;
            }else{
                return list2;
            }
        }else {
            //list12都不空
            //头节点
            ListNode head = null;
            if (list1.val < list2.val){
                head = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                head = new ListNode(list2.val);
                list2 = list2.next;
            }
            ListNode temp = head;
            //先合并
            while (list1 != null&&list2 != null){
                if (list1.val < list2.val){
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;
                    temp = temp.next;
                }else {
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;
                    temp = temp.next;
                }
            }
            //将未合并的并入
            if (list1 !=null){
                while (list1 != null){
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;
                    temp = temp.next;
                }
            }else {
                while (list2 != null){
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;
                    temp = temp.next;
                }
            }
            return head;
        }
    }
}
