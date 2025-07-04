class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] res = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = n-1 ; i >= 0 ; i--){
            if(st.isEmpty()){
                map.put(nums2[i],-1);
            }else{
                while(!st.isEmpty() && st.peek() < nums2[i]){
                    st.pop();
                    if(st.isEmpty())map.put(nums2[i],-1);
                }
                if(!st.isEmpty() && st.peek() > nums2[i]){
                    map.put(nums2[i],st.peek());
                }
            }
            st.push(nums2[i]);
        }

        for(int i = 0 ; i < nums1.length ; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}