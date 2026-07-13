class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];

        for(int i = 0 ; i < n ; i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }

        int start = 0;
        int end = 0;
        for(int i = 0 ; i < n ; i++){
            end = Math.max(end,lastIndex[s.charAt(i) - 'a']);

            if(i==end){
                res.add(end-start+1);
                start = end+1;
            }
        }

        return res;
    }
}