class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (Integer.compare(b, a)));
        Queue<int[]> q = new LinkedList<>();
        // frequency, time it can be free at
        int t = 0;

        for (int i = 0; i < tasks.length; i++) {
            char ch = tasks[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        map.forEach((key, value) -> {
            pq.offer(value);
        });

        while (!pq.isEmpty() || !q.isEmpty()) {
            t++;

            while (!q.isEmpty() && q.peek()[1] == t) {
                pq.offer(q.poll()[0]);
            }

            if (!pq.isEmpty()) {
                int f = pq.poll() - 1;
                if (f > 0) {
                    q.offer(new int[] { f, t + n + 1 });
                }
            }
        }

        return t;
    }
}