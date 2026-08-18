class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        func(1,n,k,ans,new ArrayList<>());

        return ans;
    }

    public void func(int ind,int n,int k,List<List<Integer>> ans,List<Integer> list) {
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = ind ; i <= n ; i++){
            list.add(i);
            func(i+1,n,k,ans,list);
            list.remove(list.size()-1);
        }
    }
}