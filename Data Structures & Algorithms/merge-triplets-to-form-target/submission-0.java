class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] good = new boolean[3];

        for(int i = 0; i < triplets.length; i++) {
            int[] t = triplets[i];

            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            for(int k = 0; k < 3; k++) {
                if(t[k] == target[k]) {
                    good[k] = true;
                }
            }
        }

        return good[0] && good[1] && good[2];   
    }
}