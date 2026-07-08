class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = adjList(prerequisites,n);

        List<Integer> list = topoSort(n,new ArrayList<>(),adj);

        if(list.size()!=n)return new int[]{};

        int[] res = new int[n];
        int i = 0;
        for(int num : list)res[i++]=num;
        return res;
    }

    public List<Integer> topoSort(int n, List<Integer> res, List<List<Integer>> adj) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int nei : adj.get(i)) indegree[nei]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int nei : adj.get(node)) {
                indegree[nei] -= 1;
                if (indegree[nei] == 0) q.offer(nei);
            }
        }

        return res;
    }

    public List<List<Integer>> adjList(int[][] prerequisites,int n){
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < n ; i++){ 
            adj.add(new ArrayList<>()); 
        } 
 
        for(int[] arr : prerequisites){ 
            adj.get(arr[1]).add(arr[0]); 
        } 
 
        return adj; 
    } 
}