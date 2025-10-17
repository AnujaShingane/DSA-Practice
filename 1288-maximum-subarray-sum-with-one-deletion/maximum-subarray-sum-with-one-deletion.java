class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        // noDel: best subarray sum ending at i with NO deletion
        // oneDel: best subarray sum ending at i WITH one deletion used somewhere up to i
        int noDel = arr[0];
        int oneDel = Integer.MIN_VALUE / 2; // effectively -inf so we don't use it at i=0
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            // If we delete current arr[i], we take noDel (best up to i-1 without deletion)
            // Or we keep arr[i] after having deleted something earlier: oneDel + arr[i]
            oneDel = Math.max(oneDel + arr[i], noDel);

            // Standard Kadane step (no deletion path)
            noDel = Math.max(noDel + arr[i], arr[i]);

            ans = Math.max(ans, Math.max(noDel, oneDel));
        }
        return ans;
    }
}
