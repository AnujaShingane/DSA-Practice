/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode temp = headA;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = headB;

        ListNode s = headA;
        ListNode f = headA;
        Boolean hasCycle = false;
        
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if(s == f){
                hasCycle = true;
                break;
            }
        }
        if(!hasCycle){
            temp.next = null;
            return null;
        }

        s = headA;
        while(s!=f){
            s = s.next;
            f = f.next;
        }
        temp.next = null;
        return s;
    }
}



// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) {
//  *         val = x;
//  *         next = null;
//  *     }
//  * }
//  */
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if(headA == null || headB == null){
//             return null;
//         }

//         ListNode temp = headA;
//         while(temp.next != null){
//             temp = temp.next;
//         }
//         temp.next = headB;

//         //floyd cycle
//         ListNode slow = headA;
//         ListNode fast = headA;
//         Boolean hasCycle = false;

//         while(fast != null && fast.next != null){
//             slow = slow.next;
//             fast = fast.next.next;

//             if(slow == fast){
//                 hasCycle = true;
//                 break;
//             }
//         }

//         if(!hasCycle){
//             temp.next = null;  // Restore the list by breaking the temporary cycle
//             return null;
//         }
//         slow = headA;  // Move slow pointer to the head of listA
//         while (slow != fast) {
//             slow = slow.next;
//             fast = fast.next;
//         }

//         // Step 6: Restore the original structure of the lists by breaking the cycle
//         temp.next = null;  // Break the link from listA to listB

//         // Return the intersection node
//         return slow;
//     }
// }   