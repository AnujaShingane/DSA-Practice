class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int[] result = new int[nums1.length];

        for(int i = nums2.length-1 ; i >= 0 ; i--){
            while(!st.isEmpty() && nums2[i] >= st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }

            st.push(nums2[i]);
        }
        for(int i = 0 ; i < nums2.length ; i++){
            hmap.put(nums2[i],nge[i]);
        }
        for(int i = 0 ; i < nums1.length ; i++){
            result[i] = hmap.get(nums1[i]);
        }
        return result;
    }
}