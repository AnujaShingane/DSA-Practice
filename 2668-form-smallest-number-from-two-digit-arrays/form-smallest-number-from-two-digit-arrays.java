class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for(int i = 0 ; i < m ; i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }

        if(map.size() == n+m){
            int res = 0;
            int arr1 = getSmallest(nums1);
            int arr2 = getSmallest(nums2);

            if(arr1 < arr2)res = (arr1*10) + arr2;
            else res = (arr2*10) + arr1;
            return res;
        }else{
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int key : map.keySet()){
                if(map.get(key) == 2){
                    pq.add(key);
                }
            }
            return pq.poll();
        }
    }

    public int getSmallest(int[] arr) {
        int smallest = arr[0];
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < smallest){
                smallest = arr[i];
            }
        }
        return smallest;
    }
}