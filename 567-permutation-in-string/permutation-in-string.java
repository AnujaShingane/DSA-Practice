class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int len1 = s1.length(), len2 = s2.length();

        // Fill the counts for s1 and first window of s2
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Slide the window
        for (int i = len1; i < len2; i++) {
            if (matches(s1Count, s2Count)) return true;

            // Slide window: remove left char, add right char
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - len1) - 'a']--;
        }

        // Check last window
        return matches(s1Count, s2Count);
    }

    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
