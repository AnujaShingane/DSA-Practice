class ListNode {
    int val; // person label (1-based)
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
    }
}


public class Solution {
    public int passThePillow(int n, int time) {
        ListNode head = createDLL(n);   // create DLL with 1-based labels
        ListNode pillow = head;
        boolean right = true;

        while (time-- > 0) {
            if (right) {
                pillow = pillow.next;
                if (pillow.next == null) {
                    right = false; // reverse direction
                }
            } else {
                pillow = pillow.prev;
                if (pillow.prev == null) {
                    right = true; // reverse direction
                }
            }
        }

        return pillow.val;
    }

    public ListNode createDLL(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for (int i = 1; i <= n; i++) {
            ListNode node = new ListNode(i);
            temp.next = node;
            node.prev = temp;
            temp = node;
        }

        ListNode head = dummy.next;
        if (head != null) head.prev = null;  // detach dummy node
        return head;
    }
}
