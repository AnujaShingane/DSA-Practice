class Solution {
    public String findOrder(String[] words) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int k=26;
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        //checking for only exists one
        boolean[] exists = new boolean[26];
        for(String word: words){
            for(char ch: word.toCharArray()){
                exists[ch - 'a'] = true;
            }
        }
        for(int i=0;i<words.length -1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            
            // Invalid case
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }
            
            
            int len = Math.min(s1.length(), s2.length());
            
            for(int ptr = 0; ptr<len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) -'a').add(s2.charAt(ptr) -'a');  
                    break;
                }
            }
            
        }
        String topo = toposort(adj, k, exists);
        return topo;
    }
    //topo sort using kahns algo
    private String toposort(ArrayList<ArrayList<Integer>> adj, int v, boolean[] exists){
        
        int[] indegree = new int[v];
        //indegree
        for(int i=0;i<v;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        int charcount = 0;
        
        for(int i=0;i<v;i++){
            if(exists[i]){
                charcount++;
                if(indegree[i] ==0){
                q.add(i);
            }
            }
            
        }
        
        StringBuilder ans = new StringBuilder();
        int ind=0;
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans.append((char) (node +'a'));
            
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] ==0 && exists[it]){
                    q.add(it);
                }
            }
            
        }
        
        //checking for no cycle
        if(ans.length() != charcount){
            return "";
        }
        
        return ans.toString();
        
        
        
    }
}

