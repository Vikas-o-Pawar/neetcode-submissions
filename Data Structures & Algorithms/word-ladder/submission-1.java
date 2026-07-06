class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int w = wordList.size();
        List<List<Integer>> adj = new ArrayList<>();
        int endWordIdx = -1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[w + 1];
        int res = 1;

        for(int i = 0; i < w + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < w; i++) {
            String s = wordList.get(i);

            if(stringDiffIsOne(beginWord, s)) {
                adj.get(0).add(i + 1);
                adj.get(i + 1).add(0);
            }

            if(s.equals(endWord)) {
                endWordIdx = i + 1;
            }
        }

        if(adj.get(0).isEmpty() || endWordIdx == -1) {
            return 0;
        }

        for(int i = 0; i < w - 1; i++) {
            String s =  wordList.get(i);

            for(int j = i + 1; j < w; j++) {
                String t = wordList.get(j);

                if(stringDiffIsOne(s, t)) {
                    adj.get(i + 1).add(j + 1);
                    adj.get(j + 1).add(i + 1);
                }
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int node = q.poll();

                if(node == endWordIdx) {
                    return res;
                }

                for(int a: adj.get(node)) {
                    if(!visited[a]) {
                        q.offer(a);
                        visited[a] = true;
                    }
                }
            }

            res++;
        }

        return 0;
    }

    public boolean stringDiffIsOne(String s, String t) {
        int diff = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                diff++;
            }

            if(diff > 1) {
                return false;
            }
        }

        return diff == 1;
    }
}
