class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = nums[i]%2;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            sum += arr[i];

            if(map.containsKey(sum-k)){
                cnt += map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return cnt;
    }
}