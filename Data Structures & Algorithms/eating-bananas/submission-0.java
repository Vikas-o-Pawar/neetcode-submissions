class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int p: piles) {
            right = Math.max(right, p);
        }

        int ans = right;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(canFinish(piles, h, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        for(int p: piles) {
            hours += (k + p - 1) / k;
        }

        return hours <= h;
    }
}
