class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        // put chars that appear in 'order' first, in that order
        for (char c : order.toCharArray()) {
            while (freq[c - 'a']-- > 0) sb.append(c);
        }
        // append leftovers (not in 'order') in any deterministic order
        for (char c = 'a'; c <= 'z'; c++) {
            while (freq[c - 'a']-- > 0) sb.append(c);
        }
        return sb.toString(); 
    }
}