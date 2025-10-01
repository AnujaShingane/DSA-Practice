class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int i = 0;
        int j = n1-1;
        
        while(j<n2){
            String str = s2.substring(i,j+1);
            if(isAnagram(str,s1)){
                return true;
            }
            i++;
            j++;
        }
        return false;
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