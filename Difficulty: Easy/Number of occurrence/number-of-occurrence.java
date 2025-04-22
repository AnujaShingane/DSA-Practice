//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public int firstOcc(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] == target){
                ans = mid;
                high = mid -1;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    public int lastOcc(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] == target){
                ans = mid;
                low = mid + 1;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    int countFreq(int[] arr, int target) {
        int first = firstOcc(arr,target);
        if(first == -1){
            return 0;
        }
        int last = lastOcc(arr,target);
        return last-first+1;
    }
}
