//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> arrlist = new ArrayList<>();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == x){
                arrlist.add(i);
                break;
            }
            else if(i == n-1 && arr[i] != x){
                arrlist.add(-1);
            }
        }
        
        for(int i = n-1 ; i >= 0 ; i--){
            if(arr[i] == x){
                arrlist.add(i);
                break;
            }
            else if(i == 0 && arr[i] != x){
                arrlist.add(-1);
            }
        }
        return arrlist;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            int x = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            ArrayList<Integer> ans = ob.find(arr, x);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends