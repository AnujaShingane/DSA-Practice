//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        if (capacity <= 0) {
            return 0;
        }
        
        ArrayList<Pair> data = new ArrayList<>();
        
        for(int i=0; i<val.size(); i++) {
            data.add(new Pair(wt.get(i), val.get(i)));
        }
        
        Collections.sort(data,  Comparator.comparingDouble(
            (Pair pair) -> (double) ((double)pair.val / (double)pair.wt)).reversed());
        
        double total = 0;
        int i = 0;
        while(i<data.size() && capacity > 0) {
            if(data.get(i).wt <= capacity) {
                total += data.get(i).val;
                capacity -= data.get(i).wt;
            } else {
                total +=  ((double)data.get(i).val / (double)data.get(i).wt) * capacity;
                capacity = 0;
            }
            
            i++;
        }
        
        return total;
    }
    
    class Pair {
        int wt;
        int val;
        
        Pair(int wt, int val) {
            this.wt = wt;
            this.val = val;
        }
    }
}