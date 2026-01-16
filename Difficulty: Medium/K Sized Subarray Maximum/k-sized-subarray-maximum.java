
class Pair{
    int ind;
    int val;

    Pair(int ind,int val){
        this.ind=ind;
        this.val = val;
    }
}

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Pair> q = new ArrayDeque<>();
        int ind=0;
        
        for(int i = 0 ; i < n ; i++){

            while(!q.isEmpty() && q.peekLast().val<=nums[i]){
                q.pollLast();
            }

            if(q.isEmpty() || q.peekLast().val>nums[i]){
                q.add(new Pair(i,nums[i]));
            }

            if(!q.isEmpty() && q.peekFirst().ind <= i-k){
                q.pollFirst();
            }

            if(i>=k-1){
                list.add(q.peekFirst().val);
            }
        }
        
        return list;
    }
}


// class Pair{
//     int ind;
//     int val;

//     Pair(int ind,int val){
//         this.ind=ind;
//         this.val = val;
//     }
// }

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int[] arr = new int[n-k+1];

//         Deque<Pair> q = new ArrayDeque<>();
//         int ind=0;
//         for(int i = 0 ; i < n ; i++){

//             while(!q.isEmpty() && q.peekLast().val<=nums[i]){
//                 q.pollLast();
//             }

//             if(q.isEmpty() || q.peekLast().val>nums[i]){
//                 q.add(new Pair(i,nums[i]));
//             }

//             if(!q.isEmpty() && q.peekFirst().ind <= i-k){
//                 q.pollFirst();
//             }

//             if(i>=k-1){
//                 arr[ind++]=q.peekFirst().val;
//             }
//         }
        
//         return arr;
//     }
// }

