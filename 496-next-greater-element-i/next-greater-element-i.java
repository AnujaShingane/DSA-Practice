class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++){
            int z = nextGreater(nums1[i], nums2);
            result[i] = z;
        }
        return result;
    }

    public int nextGreater(int num, int[] nums2){
        for(int i = 0; i < nums2.length; i++){
            if(nums2[i] == num){
                for(int j = i+1; j < nums2.length; j++){
                    if(nums2[j] > num){
                        return nums2[j];
                    }
                }
                break;
            }
        }
        return -1;
    }
}
