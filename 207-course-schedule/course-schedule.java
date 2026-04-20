class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = adjList(numCourses,prerequisites);
        boolean cycle = isCycle(numCourses,adj);

        if(!cycle)return true;
        return false;
    }

    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int nei : adj.get(i)) {
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int nei : adj.get(node)) {
                indegree[nei] -= 1;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return count != n; // cycle if not all processed
    }

    public ArrayList<ArrayList<Integer>> adjList(int numCourses,int[][] prerequisites){
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