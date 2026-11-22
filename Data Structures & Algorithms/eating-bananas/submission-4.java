class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().orElse(0);
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (timetaken(piles, mid) > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    int timetaken(int[] piles, int rate) {
        int time = 0;
        for (int pile : piles) {
            time = time + (pile + rate - 1) / rate;
        }
        return time;
    }
}
