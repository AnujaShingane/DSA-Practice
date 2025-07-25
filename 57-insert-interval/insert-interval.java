class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length + 1][2];
        int insertIndex = intervals.length;

        // Find correct index to insert newInterval
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[0]) {
                insertIndex = i;
                break;
            }
        }

        // Fill newArr by inserting newInterval at insertIndex
        for (int i = 0; i < insertIndex; i++) {
            newArr[i] = intervals[i];
        }
        newArr[insertIndex] = newInterval;
        for (int i = insertIndex; i < intervals.length; i++) {
            newArr[i + 1] = intervals[i];
        }

        return merge(newArr);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.get(list.size() - 1);
            int[] current = intervals[i];

            if (last[1] >= current[0]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                list.add(current);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
