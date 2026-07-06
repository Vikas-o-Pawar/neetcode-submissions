class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;

        for(int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;

            if(i == n - 1) sum++;

            if(sum > 9) {
                digits[i] = sum % 10;
                carry = sum / 10;
            } else {
                digits[i] = sum;
                carry = 0;
            }

            if(i == 0 && sum > 9) {
                int[] newDigits = new int[n + 1];
                newDigits[0] = carry;

                for(int k = 1; k < n; k++) {
                    newDigits[k] = digits[k - 1];
                }

                return newDigits;
            }
        }

        return digits;
    }
}