class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String str1 = new String(ch);

            map.putIfAbsent(str1,new ArrayList<>());
            map.get(str1).add(str);
        }

        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;
    }
}