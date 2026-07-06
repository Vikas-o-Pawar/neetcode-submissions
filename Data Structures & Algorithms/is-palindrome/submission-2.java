class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = getBuilder(s);

        return isPal(sb.toString());
    }

    public boolean isPal(String s) {
        int i = 0; 
        int j = s.length() - 1;

        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++; j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public StringBuilder getBuilder(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while(i < s.length()) {
            char c = s.charAt(i);

            if(isalphanum(c)) {
                if(isupper(c)) {
                    c = tolower(c);
                }

                sb.append(c);
            }

            i++;
        }

        return sb;
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