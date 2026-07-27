class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        func(0,0,arr,res);
        
        return res;
    }
    
    public void func(int ind,int sum,int[] arr,ArrayList<Integer> res) {
        if(ind==arr.length){
            res.add(sum);
            return;
        }
        
        //take
        func(ind+1,sum+arr[ind],arr,res);
        
        //nottake
        func(ind+1,sum,arr,res);
    }
}