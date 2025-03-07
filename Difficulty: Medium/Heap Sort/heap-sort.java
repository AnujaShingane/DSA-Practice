//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().heapSort(arr);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            // System.out.println();

            System.out.println();

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();//minPQ
        
        for(int ele : arr){
            pq.add(ele);
        }
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = pq.remove();
        }
    }
}
