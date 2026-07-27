class Solution {
    public List<String> powerSet(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        
        for(int i = 0 ; i < (1<<n) ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n ; j++){
                if((i & (1<<j))!=0)sb.append(s.charAt(j));
            }
            list.add(sb.toString());
        }
        
        Collections.sort(list);
        
        return list;
    }
}