class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deq = new LinkedList<>(); // indexes , dsc how ?
//nums=[1,2,1,0,4,2,6] k = 3
        int l = 0, r = 0;
        while (r < nums.length) {//1,2,1,0,4

            // check if last  > nums[r]
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[r]) {//empty nums[deq.last] < 2T;2<1F;1<0F;1<4T
                deq.removeLast(); //rm 0 3-1,2-1,1-2
            }
            deq.addLast(r); // index //1-2;2-1;3-1 all gone 4-4
            if (l > deq.getFirst()) { //0>0F; 0>1F;0>1F; 1>1F; 2> 4F
                deq.removeFirst();
            }

            if (r - l + 1 >= k) {//1>=3F;2>=3F;3=3T;3-1+1=3T;3
                res[l] = nums[deq.getFirst()]; //2,2,4
                l++; //1,2,3
            }
            r++; //0 to 1;2;3;4;5
        }
        return res;
    }
}
