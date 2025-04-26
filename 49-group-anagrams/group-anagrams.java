class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) continue;  // skip already grouped strings

            List<String> sublist = new ArrayList<>();
            sublist.add(strs[i]);  // always add the current string

            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j] != null && isAnagram(strs[i], strs[j])) {
                    sublist.add(strs[j]);
                    strs[j] = null;  // mark it as grouped
                }
            }
            list.add(sublist);
        }
        return list;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        return smap.equals(tmap);
    }
}
