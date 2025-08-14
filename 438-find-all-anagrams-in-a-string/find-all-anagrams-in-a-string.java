class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] ch = p.toCharArray();
        Arrays.sort(ch);
        String mainSorted = new String(ch);
        List<Integer> res = new ArrayList<>();

        int i = 0;
        int j = p.length();

        while (i <= s.length() - p.length()) {
            String str = s.substring(i, j);
            if (isAnagram(mainSorted, str)) {
                res.add(i);
            }
            i++;
            j++;
        }

        return res;
    }

    public boolean isAnagram(String mainSorted, String str) {
        if (mainSorted.length() != str.length()) return false;

        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
            arr[mainSorted.charAt(i) - 'a']--;
        }

        for (int count : arr) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
