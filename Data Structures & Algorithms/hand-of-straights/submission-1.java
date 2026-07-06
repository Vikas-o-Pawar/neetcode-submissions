class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        for(int i = 0; i < n; i++) {
            if(map.get(hand[i]) == 0) continue;

            for(int x = hand[i]; x < (hand[i] + groupSize); x++) {
                if(!map.containsKey(x) || map.get(x) <= 0) {
                    return false;
                }

                map.put(x, map.get(x) - 1);
            } 
        }

        return true;
    }
}
