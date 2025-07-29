class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())return false;
        HashMap<Character,Character> mapST = new HashMap<>();
        HashMap<Character,Character> mapTS = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            if(!mapST.containsKey(s.charAt(i))){
                mapST.put(s.charAt(i),t.charAt(i));
            }else{
                if(mapST.get(s.charAt(i)) != t.charAt(i))return false;
            }

            if(!mapTS.containsKey(t.charAt(i))){
                mapTS.put(t.charAt(i),s.charAt(i));
            }else{
                if(mapTS.get(t.charAt(i)) != s.charAt(i))return false;
            }
        }
        return true;
    }
}