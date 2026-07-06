class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int m = s1.length();
        int n = s2.length();

        for(int i = 0; i < m; i++) {
            arr1[s1.charAt(i) - 'a']++;
        }

        int j = 0;
        int i = 0;

        while(j < m) {
            arr2[s2.charAt(j) - 'a']++;
            j++;
        }

        while(j < n) {
            if(Arrays.equals(arr1, arr2)) {
                return true;
            }

            arr2[s2.charAt(i) - 'a']--;
            i++;

            arr2[s2.charAt(j) - 'a']++;
            j++;
        }

        return Arrays.equals(arr1, arr2);
    }
}
