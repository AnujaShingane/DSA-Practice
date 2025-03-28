//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // Step 1: Move all elements from Stack to ArrayList
        while (!s.isEmpty()) {
            list.add(s.pop());
        }
        
        // Step 2: Sort in descending order
        Collections.sort(list);
        
        // Step 3: Push sorted elements back to Stack
        for (int num : list) {
            s.push(num);
        }
        
        return s;
    }
}