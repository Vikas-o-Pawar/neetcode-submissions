class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        List<Integer> rs = new ArrayList<>();

        for(int k: nums) map.put(k, map.getOrDefault(k, 0) + 1);

        map.forEach((key, value) -> {
            if(value > (n / 3)) {
                rs.add(key);
            }
        });

        return rs;
    }
}