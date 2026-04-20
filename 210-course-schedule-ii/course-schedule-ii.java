class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = adjecencyList(numCourses,prerequisites);
        List<Integer> ans = topoSort(numCourses,adj);

        if(ans.size()<numCourses)return new int[]{};
        int[] res = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            res[i] = ans.get(i);
        }

        return res;
    }

    public List<Integer> topoSort(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int nei : adj.get(i)) indegree[nei]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        List<Integer> res = new ArrayList<>();

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

    public ArrayList<ArrayList<Integer>> adjecencyList(int numCourses,int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }

        return adj;
    }
}