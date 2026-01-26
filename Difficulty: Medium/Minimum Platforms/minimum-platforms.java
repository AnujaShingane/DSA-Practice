class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int p = 0;
        int mp = 0;
        int i = 0;
        int j = 0;
        
        while(i < n && j < n){
            if(arr[i]<=dep[j]){
                p++;
                i++;
                mp = Math.max(mp,p);    
            }else{
                p--;
                j++;
            }
        }
        
        return mp;
    }
}
