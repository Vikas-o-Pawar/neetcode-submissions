class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] cars = new int[n][2];
        Stack<Double> stk = new Stack<>();

        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b)-> Integer.compare(a[0], b[0]));

        for(int i = n - 1; i >= 0; i--) {
            int p = cars[i][0];
            int s = cars[i][1];

            Double timeTaken = (double)  (target - p) / s;

            if(stk.isEmpty()) {
                stk.push(timeTaken);
            } else {    
                if(timeTaken > stk.peek()) {
                    stk.push(timeTaken);
                }
            }
        }

        return stk.size();
    }
}