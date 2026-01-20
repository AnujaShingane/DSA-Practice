class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = finish[i];
        }

        // Sort by finish time
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int cnt = 1;                 // first activity is always selected
        int last = arr[0][1];        // finish time of first activity

        for (int i = 1; i < n; i++) {
            if (arr[i][0] > last) {
                cnt++;
                last = arr[i][1];
            }
        }

        return cnt;
    }
}
