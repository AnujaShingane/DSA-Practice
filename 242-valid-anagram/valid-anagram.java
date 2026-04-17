class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if(s.length()!=t.length())return false;
        int[] arr = new int[26];

        for(int i = 0 ; i < n ; i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]!=0)return false;
        }

        return true;
    }
}