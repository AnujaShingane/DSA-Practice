class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        return prev;
    }
}
