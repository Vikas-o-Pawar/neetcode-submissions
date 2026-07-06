class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];

                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse
        for(int[] mat: matrix) {
            int s = 0, e = n - 1;

            while(s < e) {
                int temp = mat[s];
                mat[s] = mat[e];
                mat[e] = temp;

                s++;
                e--;
            }
        }
    }
}
