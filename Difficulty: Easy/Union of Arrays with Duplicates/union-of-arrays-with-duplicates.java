// User function Template for Java

class Solution {
    public static int findUnion(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < a.length ; i++){
            set.add(a[i]);
        }
        for(int i = 0 ; i < b.length ; i++){
            set.add(b[i]);
        }
        
        return set.size();
    }
}