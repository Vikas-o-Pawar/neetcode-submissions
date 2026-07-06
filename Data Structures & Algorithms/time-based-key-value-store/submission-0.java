class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // if(!map.containsKey(key)) {
        //     List<Pair> ls = new ArrayList<>();
        //     ls.add(new Pair(timestamp, value));
        //     map.put(key, ls);
        // } else {
        //     List<Pair> ls = map.get(key);
        //     ls.add(new Pair(timestamp, value));
        //     map.put(key, ls);
        // }

        List<Pair> ls = map.getOrDefault(key, new ArrayList<Pair>());
        ls.add(new Pair(timestamp, value));
        map.put(key, ls);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }

        List<Pair> ls = map.get(key);
        int search = binarySearch(ls, timestamp);

        if(search == -1) {
            return "";
        }

        return ls.get(search).val;
    }

    public int binarySearch(List<Pair> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr.get(mid).timestamp < target) {
                start = mid + 1;
            } else if(arr.get(mid).timestamp > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return end;
    }

    private static class Pair{
        int timestamp;
        String val;

        public Pair(int timestamp, String val) {
            this.timestamp = timestamp;
            this.val = val;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */