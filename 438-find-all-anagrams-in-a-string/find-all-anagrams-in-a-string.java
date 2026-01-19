class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i <= s.length()-p.length() ; i++){
            String s1 = s.substring(i,i+p.length());
            if(isAnagram(s1,p))list.add(i);
        }
        
        return list;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];

        Arrays.fill(arr,0);
        for(int i = 0 ; i < s.length() ; i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != 0)return false;
        }
        return true;
    }
}