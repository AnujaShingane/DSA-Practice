class Solution {
    public List<List<Integer>> combine(int n, int k) {
        HashSet<List<Integer>> set = new HashSet<>();
        int[] arr = new int[n];

        for(int i = 1 ; i <= n ; i++){
            arr[i-1] = i;
        }

        for(int i = 0 ; i < (1<<arr.length) ; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                if((i&(1<<j))!=0){
                    list.add(arr[j]);
                }
            }
            if(list.size()==k)set.add(list);
        }

        List<List<Integer>> res = new ArrayList<>(set);

        return res;
    }
}