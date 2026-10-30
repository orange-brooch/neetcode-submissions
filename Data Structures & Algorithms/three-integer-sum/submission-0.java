class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        int n = num.length;
        Arrays.sort(num);
        for (int i = 0; i < n ; i++) {
            if (num[i] > 0)
                break;
            if (i > 0 && num[i] == num[i - 1])
                continue;

            int lt = i + 1;
            int rt = n - 1;
            while (lt < rt) {
                int target = num[i] + num[lt] + num[rt];

                if (target < 0) {
                    lt++;
                } else if (target > 0) {
                    rt--;
                } else if (target == 0) {
                    res.add(Arrays.asList(num[i], num[lt], num[rt]));
                    lt++;
                    rt--;
                    while (lt < rt && num[lt] == num[lt - 1]) {
                        lt++;
                    }
                }
            }
        }
        return res;
    }
}
