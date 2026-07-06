class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        wordList.add(beginWord);
        int w = wordList.size();
        int res = 1;

        for(int i = 0; i < w; i++) {
            String word = wordList.get(i);

            for(int j = 0; j < word.length(); j++) {
                StringBuilder pattern = new StringBuilder();
                int p = 0;

                while(p < j) {
                    pattern.append(word.charAt(p++));
                }

                pattern.append("*");
                p  = j + 1;
                while(p < word.length()) {
                    pattern.append(word.charAt(p++));
                }

                List<String> ls = map.getOrDefault(pattern.toString(), new ArrayList<>());
                ls.add(word);
                map.put(pattern.toString(), ls);
            }

        }

        System.out.println(map);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {
                String word = q.poll();

                if(word.equals(endWord)) {
                    return res;
                }

                for(int j = 0; j < word.length(); j++) {
                    StringBuilder pattern = new StringBuilder();
                    int p = 0;

                    while(p < j) {
                        pattern.append(word.charAt(p++));
                    }

                    pattern.append("*");
                    p  = j + 1;
                    while(p < word.length()) {
                        pattern.append(word.charAt(p++));
                    }

                    for(String nei: map.getOrDefault(pattern.toString(), new ArrayList<>())) {
                        if(!visited.contains(nei)) {
                            q.offer(nei);
                            visited.add(nei);
                        }
                    }
                }
            }

            res++;
        }

        return 0;
    }
}