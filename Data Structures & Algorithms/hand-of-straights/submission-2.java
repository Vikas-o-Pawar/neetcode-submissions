class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);

        for(int x: hand) map.put(x, map.getOrDefault(x, 0) + 1);

        for(int i = 0; i < n; i++) {
            if(map.get(hand[i]) == 0) continue;

            for(int x = hand[i]; x < hand[i] + groupSize; x++) {
                if(!map.containsKey(x) || map.get(x) <= 0) return false;

                map.put(x, map.get(x) - 1);
            }
        }

        return true;
    }
}