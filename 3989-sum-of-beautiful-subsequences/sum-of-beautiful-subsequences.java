class Solution {
    static final int MOD = 1_000_000_007;

    public int totalBeauty(int[] nums) {
        int n = nums.length;
        int maxA = 0;
        for (int v : nums) if (v > maxA) maxA = v;
        // lists[z] will contain the sequence of values nums[i] that are divisible by z (in original order)
        ArrayList<Integer>[] lists = new ArrayList[maxA + 1];
        for (int i = 1; i <= maxA; ++i) lists[i] = new ArrayList<>();

        // For each nums[i], add its value to all divisor lists (preserve order by iterating nums in order)
        for (int v : nums) {
            int lim = (int)Math.sqrt(v);
            for (int d = 1; d <= lim; ++d) {
                if (v % d == 0) {
                    lists[d].add(v);
                    int other = v / d;
                    if (other != d) lists[other].add(v);
                }
            }
        }

        long[] f = new long[maxA + 1]; // f[z] = count of increasing subsequences with all elements divisible by z
        // For each z, count strictly increasing subsequences in lists[z]
        for (int z = 1; z <= maxA; ++z) {
            ArrayList<Integer> seq = lists[z];
            if (seq.isEmpty()) continue;

            // coordinate compress values in seq (only values appear, duplicates allowed)
            int m = seq.size();
            int[] arr = new int[m];
            for (int i = 0; i < m; ++i) arr[i] = seq.get(i);
            int[] sorted = arr.clone();
            Arrays.sort(sorted);
            // dedupe
            int uniqCnt = 0;
            for (int x : sorted) if (uniqCnt == 0 || sorted[uniqCnt - 1] != x) sorted[uniqCnt++] = x;
            // map value -> compressed index (1-based)
            HashMap<Integer,Integer> rank = new HashMap<>(uniqCnt * 2);
            for (int i = 0; i < uniqCnt; ++i) rank.put(sorted[i], i + 1);

            Fenwick bit = new Fenwick(uniqCnt);
            long total = 0;
            for (int x : arr) {
                int idx = rank.get(x);
                long smallerSum = bit.sum(idx - 1); // sum of counts of subsequences ending at values < x
                long cur = (1 + smallerSum) % MOD;  // either start new single-element subsequence or extend
                bit.add(idx, cur);
                total += cur;
                if (total >= MOD) total -= MOD;
            }
            f[z] = total % MOD;
        }

        // Inclusion-exclusion to get counts for gcd exactly z: g[z] = f[z] - sum_{k>1} g[k*z]
        long[] g = new long[maxA + 1];
        for (int z = maxA; z >= 1; --z) {
            long val = f[z];
            for (int multiple = z + z; multiple <= maxA; multiple += z) {
                val -= g[multiple];
                if (val < - (1L<<60)) val %= MOD; // safety (not really needed)
            }
            val %= MOD;
            if (val < 0) val += MOD;
            g[z] = val;
        }

        long ans = 0;
        for (int z = 1; z <= maxA; ++z) {
            if (g[z] == 0) continue;
            ans = (ans + (z * (g[z] % MOD)) % MOD) % MOD;
        }
        return (int)ans;
    }

    // Fenwick (1-based)
    static class Fenwick {
        int n;
        long[] bit;
        Fenwick(int n) {
            this.n = n;
            bit = new long[n + 1];
        }
        void add(int idx, long delta) {
            while (idx <= n) {
                bit[idx] += delta;
                if (bit[idx] >= MOD) bit[idx] -= MOD;
                idx += idx & -idx;
            }
        }
        long sum(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                if (res >= MOD) res -= MOD;
                idx -= idx & -idx;
            }
            return res % MOD;
        }
    }
}