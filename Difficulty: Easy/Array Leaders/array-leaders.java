class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        int n = arr.length;
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        res.add(arr[n-1]);
        for(int i = n-2 ; i >= 0 ; i--){
            if(res.get(res.size()-1) <= arr[i]){
                res.add(arr[i]);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
