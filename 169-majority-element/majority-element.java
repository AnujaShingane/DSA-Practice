class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();

        int n = nums.length/2;
        
        for (int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        for(int key : hmap.keySet()){
            if(hmap.get(key) > n){
                return key;
            }
        }
        return -1;
    }
}