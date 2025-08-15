class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNote1 = new int[26];
        int[] magazine1 = new int[26];
        Arrays.fill(ransomNote1,0);
        Arrays.fill(magazine1,0);
        
        for(int i = 0 ; i < ransomNote.length() ; i++){
            ransomNote1[ransomNote.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < magazine.length() ; i++){
            magazine1[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(ransomNote1[i]>magazine1[i])return false;
        }
        return true;
    }
}