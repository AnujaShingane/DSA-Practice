class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = asteroids.length;
        list.add(asteroids[0]);

        for (int i = 1; i < n; i++) {
            int curr = asteroids[i];

            while (!list.isEmpty() && list.get(list.size() - 1) > 0 && curr < 0) {
                int last = list.get(list.size() - 1);
                
                if (Math.abs(last) < Math.abs(curr)) {
                    list.remove(list.size() - 1); // ✅ Fix: use index-based removal
                } else if (Math.abs(last) == Math.abs(curr)) {
                    list.remove(list.size() - 1); // ✅ both explode
                    curr = 0;                     // ✅ current also destroyed
                    break;
                } else {
                    curr = 0; // ✅ current destroyed by larger one
                    break;
                }
            }

            if (curr != 0) {
                list.add(curr); // ✅ only add if it survived
            }
        }

        // Convert list to array
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
