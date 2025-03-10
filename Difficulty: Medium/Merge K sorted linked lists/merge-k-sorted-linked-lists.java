//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Node> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                Node head = null, temp = null;

                for (String value : values) {
                    Node newNode = new Node(Integer.parseInt(value));
                    if (head == null) {
                        head = newNode;
                        temp = head;
                    } else {
                        temp.next = newNode;
                        temp = temp.next;
                    }
                }

                lists.add(head);
            }

            Solution sol = new Solution();
            Node head = sol.mergeKLists(lists);

            printList(head);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// arr is an array of Nodes of the heads of linked lists

class Pair {
    int val;
    Node node;
    
    Pair(int val, Node node){
        this.val = val;
        this.node = node;
    }
}

class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(Node n : arr){
            if(n != null){
                pq.add(new Pair(n.data,n));
            }
        }
        
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        while(!pq.isEmpty()){
            Pair n1 = pq.remove();
            int value = n1.val;
            Node n2 = n1.node;
            
            temp.next = new Node(value);
            temp = temp.next;
            
            if(n2.next != null){
                pq.add(new Pair(n2.next.data,n2.next));
            }
        }
        
        return dummy.next;
    }
}