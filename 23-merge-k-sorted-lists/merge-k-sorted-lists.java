/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);

        for(ListNode node : lists){
            if(node != null){
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode rem = pq.remove();
            curr.next = rem;
            curr = curr.next;

            if(rem.next != null){
                pq.add(rem.next);
            }
        }
        return dummy.next;
    }
}