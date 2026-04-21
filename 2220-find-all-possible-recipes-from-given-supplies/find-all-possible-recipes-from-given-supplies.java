class Solution {

    public List<String> findAllRecipes(String[] recipes,
                                       List<List<String>> ingredients,
                                       String[] supplies) {

        HashMap<String, ArrayList<String>> map =
                adjMap(recipes, ingredients, supplies);

        List<String> topo = topoSort(map, recipes, supplies);

        HashSet<String> reciSet = new HashSet<>();
        for (String r : recipes) reciSet.add(r);

        List<String> res = new ArrayList<>();

        for (String s : topo) {
            if (reciSet.contains(s)) res.add(s);
        }

        return res;
    }

    public List<String> topoSort(HashMap<String, ArrayList<String>> map,
                                 String[] recipes,
                                 String[] supplies) {

        HashMap<String, Integer> indegree = new HashMap<>();

        for (String key : map.keySet()) {
            indegree.put(key, 0);
        }

        for (String key : map.keySet()) {
            for (String nei : map.get(key)) {
                indegree.put(nei, indegree.get(nei) + 1);
            }
        }

        Queue<String> q = new LinkedList<>();

        // ONLY supplies start available
        for (String s : supplies) {
            q.offer(s);
        }

        List<String> res = new ArrayList<>();

        while (!q.isEmpty()) {

            String cur = q.poll();
            res.add(cur);

            for (String nei : map.get(cur)) {

                int val = indegree.get(nei) - 1;
                indegree.put(nei, val);

                if (val == 0) {
                    q.offer(nei);
                }
            }
        }

        return res;
    }

    public HashMap<String, ArrayList<String>> adjMap(String[] recipes,
                                                     List<List<String>> ingredients,
                                                     String[] supplies) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String r : recipes) map.put(r, new ArrayList<>());
        for (String s : supplies) map.putIfAbsent(s, new ArrayList<>());

        for (int i = 0; i < recipes.length; i++) {

            String recipe = recipes[i];

            for (String ing : ingredients.get(i)) {
                map.putIfAbsent(ing, new ArrayList<>());
                map.get(ing).add(recipe);
            }
        }

        return map;
    }
}