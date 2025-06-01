class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(i < n && j < m){
            if(nums1[i] == nums2[j]){
                if(list.isEmpty() || list.get(list.size()-1) != nums1[i]){
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }
        }
        int[] res = new int[list.size()];
        for(i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}