import java.util.*;

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;

        List<Integer> ind_list = new ArrayList<>();

        while (n != 0) {
            int rem = n % 2;
            ind_list.add(rem);
            n = n / 2;
        }

        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < ind_list.size(); i++) {
            if (ind_list.get(i) == 1) {
                int pow = (int) Math.pow(2, i); 
                powers.add(pow);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] arr : queries) {
            int res = 1;                      
            int first_ind = arr[0];
            int second_ind = arr[1];

            for (int i = first_ind; i <= second_ind; i++) {
                // prevent overflow, apply modulo (no loop changes)
                res = (int) ((long) res * powers.get(i) % MOD);
            }
            ans.add(res);
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
