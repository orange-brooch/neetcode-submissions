class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        //[-1,-1,-4,0,1,2]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int target = nums[i] + nums[l] + nums[r];
                if (target > 0) {
                    r--;
                } else if (target < 0) {
                    l++;
                } else if (target == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // inc only if matched
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
