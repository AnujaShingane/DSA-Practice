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
        public ListNode reverseList(ListNode head) {
            if(head == null){
                return null;
            }

            ListNode prev = null, curr = head, nextNode = head.next;
            while(nextNode != null){
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                nextNode = nextNode.next;
            }
            curr.next = prev;
            return curr;
        }
    }