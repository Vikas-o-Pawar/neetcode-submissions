class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;

        while(i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            while(!isalphanum(ci)) {
                i++;

                if(i == s.length()) {
                    break;
                }

                ci = s.charAt(i);
            }

            while(!isalphanum(cj)) {
                j--;

                if(j == -1) {
                    break;
                }
                cj = s.charAt(j);
            }

            if(j < i) {
                break;
            }

            if(isupper(ci)) {
                ci = tolower(ci);
            }

            if(isupper(cj)) {
                cj = tolower(cj);
            }

            if(ci == cj) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isupper(char c) {
        return Character.isUpperCase(c);
    }

    public char tolower(char c) {
        return Character.toLowerCase(c);
    }

    public boolean isalphanum(char c) {
        return Character.isLetterOrDigit(c);
    }
}