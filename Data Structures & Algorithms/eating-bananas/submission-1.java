class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // given piles of fuits, what rate of picking/eating meets the given hour window ?
        // start with 1 go all they will max fruit int he tree- that takes o(m.n) where m -> max num
        // of fruit int  he tree.
        int l = 1, r = Arrays.stream(piles).max().orElse(0);

        while (l < r) {
            int m = l + (r-l)/2;
            //if too slow move l pointer inward
            if(timetaken(piles, m) > h){
                l = m + 1;
            }else{
                r = m; //cz r is a valid high rate
            }

        }
        return l;
    }

    private static int timetaken(int[] piles, int rate){ int time = 0;
    for(int pile : piles){
        time += (pile + rate - 1)/rate;
    }

return time;
    }
}
