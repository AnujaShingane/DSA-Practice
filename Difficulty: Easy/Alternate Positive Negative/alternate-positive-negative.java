// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        int n = arr.size();
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            if(arr.get(i) >= 0)pos.add(arr.get(i));
            if(arr.get(i) < 0)neg.add(arr.get(i));
        }
        int i = 0 ,j = 0,z = 0;
        while(i < pos.size() && j < neg.size()){
            if(z%2 == 0){
                arr.set(z++,pos.get(i++));
            }else{
                arr.set(z++,neg.get(j++));
            }
        }
        
        while(i < pos.size()){
            arr.set(z++,pos.get(i++));
        }
        
        while(j < neg.size()){
            arr.set(z++,neg.get(j++));
        }
    }
}