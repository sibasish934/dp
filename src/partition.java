class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head ==null || head.next == null){
            return head;
        }

        ListNode List1 = new ListNode(0);
        ListNode List2 = new ListNode(0);

        ListNode temp1 = List1;
        ListNode temp2 = List2;

        while(head != null){
            if(head.val < x){
                temp1.next = head;
                temp1 = temp1.next;
            }else{
                temp2.next = head;
                temp2 = temp2.next;
            }

            head = head.next;
        }

        temp1.next = List2.next;
        temp2.next = null;
        return List1.next;

    }
}
