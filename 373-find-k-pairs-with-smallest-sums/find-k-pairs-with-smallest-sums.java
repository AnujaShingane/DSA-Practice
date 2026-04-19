class Pair{
    int i;
    int j;
    int sum;

    Pair(int i, int j, int sum){
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums1.length == 0 || nums2.length == 0 || k == 0){
            return ans;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.sum - b.sum
        );

        // first column add
        for(int i = 0; i < nums1.length && i < k; i++){
            pq.add(new Pair(i, 0, nums1[i] + nums2[0]));
        }

        while(k > 0 && !pq.isEmpty()){

            Pair cur = pq.poll();

            ans.add(Arrays.asList(nums1[cur.i], nums2[cur.j]));
            k--;

            // move right in nums2
            if(cur.j + 1 < nums2.length){
                pq.add(new Pair(
                    cur.i,
                    cur.j + 1,
                    nums1[cur.i] + nums2[cur.j + 1]
                ));
            }
        }

        return ans;
    }
}