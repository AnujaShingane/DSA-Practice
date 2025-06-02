class Solution {
    public int getSecondLargest(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-heap by default
        HashSet<Integer> set = new HashSet<>();
        // for(int i = 0 ; i < n ; i ++){
        //     set.add(arr[i]);
        // }

        for(int i = 0; i < arr.length; i++) {
            if(!set.contains(arr[i])) pq.add(arr[i]);               // Add every element
            set.add(arr[i]);
            if(pq.size() > 2) {
                pq.remove();              // Remove the smallest element when size > k
            }
        }
        if(pq.size()<2) return -1;
        return pq.peek(); // kth largest element will be at the top
    }
}