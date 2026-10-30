class Solution {
    public int[] topKFrequent(int[] nums, int k) {
Map<Integer, Integer> freqmap = new HashMap<>();
    for(int num : nums){
    freqmap.merge(num, 1, Integer::sum);
    }

   // System.out.println(freqmap);
// create a PQ of int [] type in asc orger
    PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
    for(Map.Entry<Integer, Integer> entry : freqmap.entrySet()){
        heap.offer(new int[]{entry.getValue(), entry.getKey()});
        if(heap.size() > k){
            heap.poll();
        }
    }
       // System.out.println(heap);

        int[] result = new int[k];
        for(int i =0; i< k; i++){
            result[i] = heap.poll()[1];
        }

        return result;
}
}
