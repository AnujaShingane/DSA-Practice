class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String[] strArr = s.split(" ");
        HashMap<Character,String> map = new HashMap<>();
        if(pattern.length() != strArr.length)return false;

        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(strArr[i]))return false;
            map.putIfAbsent(pattern.charAt(i),strArr[i]);
        }

        HashSet<String> set = new HashSet<>();
        for(String val : map.values()){
            set.add(val);
        }
        if(set.size()<map.size())return false;

        return true;
    }
}