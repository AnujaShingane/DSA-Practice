class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> tmap = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0 ; i < t.length() ; i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }
        
        if(smap.equals(tmap))return true;
        return false;
    }
}