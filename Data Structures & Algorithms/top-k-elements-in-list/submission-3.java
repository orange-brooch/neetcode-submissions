class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.merge(n, 1, Integer::sum);
        }
        // create a PR of int array type in asc order
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // count , num
            heap.add(new int[] {entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }
        // create a int array of size k
        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }
}
