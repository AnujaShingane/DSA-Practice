class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();

        while(i < m && j < n){
            if(nums1[i] < nums2[j]){    
                list.add(nums1[i]);
                i++;
            }else if(nums1[i] > nums2[j]){
                list.add(nums2[j]);
                j++;
            }else{
                list.add(nums1[i]);
                list.add(nums2[j]);
                i++;
                j++;
            }
        }

        while(i < m){
            list.add(nums1[i]);
            i++;
        }

        while(j < n){
            list.add(nums2[j]);
            j++;
        }

        for(i = 0 ; i < list.size() ; i++){
            nums1[i] = list.get(i);
        }
    }
}