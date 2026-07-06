class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = (m * n) - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            int val = matrix[mid / n][mid % n];
            // Division (/) tells you how many full rows you’ve passed
            // Modulus (%) gives you how far you are inside the current row

            if(val < target) {
                start = mid + 1;
            } else if(val > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}