class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int pl=p.length();
        int i = 0;
        int j = pl-1;
        List<Integer> res = new ArrayList<>();
        
        while(j<n){
            String str = s.substring(i,j+1);
            if(isAnagram(str,p)){
                res.add(i);
            }
            i++;
            j++;
        }
        return res;
    }

    public boolean isAnagram(String str, String p) {
        int n = str.length();
        if(str.length()!=p.length()){
            return false;
        }

        int[] arr = new int[26];
        Arrays.fill(arr,0);
        for(int i = 0 ; i < n ; i++){
            arr[str.charAt(i)-'a']++;
            arr[p.charAt(i)-'a']--;
        }

        for(int num:arr){
            if(num!=0)return false;
        }
        return true;
    }
}