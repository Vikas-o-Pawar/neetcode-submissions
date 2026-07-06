class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> pre = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            pre.add(new ArrayList<>());
        }

        for(int[] p: prerequisites) {
            int a = p[0];
            int b = p[1];
            // a, b
            // a->b - flow
            pre.get(a).add(b);
        }

        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, pre, visited)) {
                return false;
            }
        }
        
        return true;
    }

    public boolean dfs(int course, List<List<Integer>> pre, boolean[] visited) {
        if(pre.get(course).isEmpty()) {
            return true;
        }

        if(visited[course]) {
            // cycle
            return false;
        }

        visited[course] = true;

        for(int p: pre.get(course)) {
            if(!dfs(p, pre, visited)) {
                return false;
            }
        }

        visited[course] = false;
        pre.get(course).clear();

        return true;
    }
}