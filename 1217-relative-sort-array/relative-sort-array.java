class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        int[] res = new int[arr1.length];

        for(int num : arr1){
            freq[num]++;
        }

        int ind = 0;
        for(int i = 0 ; i < arr2.length ; i++){
            while(freq[arr2[i]] != 0){
                res[ind++] = arr2[i];
                freq[arr2[i]]--;
            }
        }

        for(int i = 0 ; i < freq.length ; i++){
            while(freq[i] != 0){
                res[ind++] = i;
                freq[i]--;
            }
        }
        return res;
    }
}