/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        Node newHead = reverse(head);
        Node prev = null;
        Node curr = newHead;
        int carry = 1;
        
        while(curr != null){
            int sum = curr.data+carry;
            curr.data = sum%10;
            carry = sum/10;
            
            prev = curr;
            curr = curr.next;
        }
        
        if(carry > 0){
            prev.next = new Node(carry);
        }
        return reverse(newHead);
    }
    
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}