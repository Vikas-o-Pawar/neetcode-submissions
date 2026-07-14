class CountSquares {
    List<int[]> ls;
    Map<String, Integer> map;

    public CountSquares() {
        this.ls = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    public void add(int[] point) {
        ls.add(point);
        // String key = point[0] + "@" + point[1];
        // map.put(key, map.getOrDefault(key, 0) + 1);
        map.put(point[0] + "@" + point[1], map.getOrDefault(point[0] + "@" + point[1], 0) + 1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int res = 0;
        for(int[] p: ls) {
            int px = p[0], py = p[1];

            if(px == x || py == y || Math.abs(px - x) != Math.abs(py - y)) {
                continue;
            }

            // diagonal point found
            res += map.getOrDefault(px + "@" + y, 0) * map.getOrDefault(x + "@" + py, 0);
        }

        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */