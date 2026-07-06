class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs) {
            int len = str.length();
            sb.append(String.valueOf(len));
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ls = new ArrayList<>();

        StringBuilder sb = new StringBuilder(str);

        while(sb.length() != 0) {
            int len = 0;
            while(Character.isDigit(sb.charAt(0))) {
                len = (len * 10) + (sb.charAt(0) - '0') ;
                sb.deleteCharAt(0);
            }
            
            sb.deleteCharAt(0);

            ls.add(sb.substring(0, len).toString());
            int k = 0;
            while(k < len) {
                sb.deleteCharAt(0);
                k++;
            }
        }
        
        return ls;
    }
}
