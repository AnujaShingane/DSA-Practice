class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] freqs = new int[26];
        int[] freqtar = new int[26];
        int min = Integer.MAX_VALUE;

        for(char ch : s.toCharArray()){
            freqs[ch-'a']++;
        }
        for(char ch : target.toCharArray()){
            freqtar[ch-'a']++;
        }

        for(char ch : target.toCharArray()){
            min = Math.min(min,freqs[ch-'a']/freqtar[ch-'a']);
        }

        return min;
    }
}