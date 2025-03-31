//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.intersection(a, b);
            if (res.size() == 0) {
                System.out.println("[]");
                System.out.println("~");
                continue;
            }
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    // Function to find the intersection of two arrays
    ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0 ;
        int j = 0;
        
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                if (ans.isEmpty() || ans.get(ans.size() - 1) != a[i]) {
                    ans.add(a[i]);
                }
                // ans.add(a[i]);
                i++;
                j++;
            }else if(a[i] < b[j]){
                i++;
            }else{
                j++;
            }
        }
        return ans;
    }
}