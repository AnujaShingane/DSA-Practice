class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int key : map.keySet()){
            int value = map.get(key);
            if(value>n/3){
                list.add(key);
            }
        }
        return list;
    }
}