class Solution {
    public int[][] merge(int[][] intervals) {
        // create merged list<int[]> to return
        List<int[]> merged = new ArrayList<>();

        // sort by start
        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));

        // iterate - for loop
        for (int[] interval : intervals) {
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                // get the max end time for merging
                merged.get(merged.size() - 1)[1] =
                    Math.max(interval[1], merged.get(merged.size() - 1)[1]);
            }
        }

        // return
        return merged.toArray(new int[merged.size()][]);
    }
}
