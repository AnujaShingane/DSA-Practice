class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outdegree = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            outdegree[i] = graph[i].length;
            if(graph[i].length==0)q.offer(i);
        }

        List<List<Integer>> adj = new ArrayList<>();
        int ind = 0;
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : graph){
            int index = ind++;
            for(int num : arr){
                adj.get(num).add(index);
            }
        }

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int nei : adj.get(node)){
                outdegree[nei]-=1;
                if(outdegree[nei]==0){
                    q.offer(nei);
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}