class Pair {
    int freq;
    int idx;

    Pair(int freq, int idx) {
        this.freq = freq;
        this.idx = idx;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        TreeMap<Character, Pair> map = new TreeMap<>();

        // Build map of character -> (frequency, index)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).freq++;
            } else {
                map.put(c, new Pair(1, i));
            }
        }

        // Convert to list and sort by index
        List<Pair> list = new ArrayList<>(map.values());
        list.sort((p1, p2) -> Integer.compare(p1.idx, p2.idx));

        // Find first with freq == 1
        for (Pair p : list) {
            if (p.freq == 1) return p.idx;
        }

        return -1;
    }
}
