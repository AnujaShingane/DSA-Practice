class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int sum1 = 0;
        int sum2 = 0;
        int chuncks = 0;

        for(int i = 0 ; i < n ; i++){
            sum1 += arr[i];
            sum2 += sorted[i];

            if(sum1 == sum2)chuncks++;
        }
        return chuncks;
    }
}