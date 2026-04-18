class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            String s = strs[i];
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String ss = new String(ch);

            map.putIfAbsent(ss,new ArrayList<>());
            map.get(ss).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> value : map.values()){
            res.add(value);
        }

        return res;
    }
}