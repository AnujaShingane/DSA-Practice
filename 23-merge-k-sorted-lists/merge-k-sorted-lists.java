class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Step 1: Traverse each linked list and add all node values into the min-heap
        for (ListNode head : lists) {
            while (head != null) {
                pq.add(head.val);
                head = head.next;
            }
        }

        // Step 2: Build the merged linked list from min-heap
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            current.next = new ListNode(pq.poll());
            current = current.next;
        }

        return dummy.next;
    }
}
