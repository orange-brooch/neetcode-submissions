class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // monotonic strack - deq
        Deque<Integer> deq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int l = 0, r = 0;
        while (r < nums.length) {//7- break
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[r])
                deq.removeLast();//rm 0-1,1-2,2-1,3-0,4-4,5-2
            deq.addLast(r);//6-6

            if (l > deq.getFirst()) {//FF
                deq.removeFirst();
            }
            if (r -l + 1 >= k) {//TTTTT
                res[l] = nums[deq.getFirst()];//2,2,4,4,6
                l++;//1,2,3,4,5
            }
            r++;//1,2,3,4,5,6,7
        }
        return res;
    }
}
