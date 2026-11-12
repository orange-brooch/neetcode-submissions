class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //o(n^2)
        // capture possibilities
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        // for through i
        for (int i = 0; i < n; i++) {
            //if num[i] is greated than 0 l is i+1 so obv we are not going to have -ve to sun 0
            if (nums[i] > 0) {
                break;
            }
            // avoid duplicate on i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // l is i+1
            int l = i + 1, r = n - 1;
            // we calc all possible values of l and r for each i
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
//its too positive
                if (sum > 0) {
                    r--;
                } else if (sum < 0) { // too negative - try to balance
                    l++;
                } else if (sum == 0) { // this is the condition that logs and move the pointers inward
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) { // avoid duplicate
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
