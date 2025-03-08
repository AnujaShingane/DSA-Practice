//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    class Median {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        
        public Median(){
            left = new PriorityQueue<>(Collections.reverseOrder());  //maxHeap
            right = new PriorityQueue<>(); // minHeap
        }
        
        // PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> right = new PriorityQueue<>();
        
        
        
        public void addNum(int num){
            if(left.size() == right.size()){
                right.add(num);
                left.add(right.remove());
            }else{
                left.add(num);
                right.add(left.remove());
            }
        }
        
        public double getMedian(){
            if(left.size() == right.size()){
                return (left.peek() + right.peek())/2.0;
            }else{
                return left.peek()*1.0;
            }
        }
    }
    
    public ArrayList<Double> getMedian(int[] arr) {
        int n = arr.length;
        ArrayList<Double> list = new ArrayList<>();
        Median median = new Median();
        
        for(int i = 0 ; i < n ; i++){
            median.addNum(arr[i]);
            list.add(median.getMedian());
        }
        return list;
    }
}