class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] p: prerequisites) {
            adj.get(p[0]).add(p[1]);
        }

        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, adj, visited)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course, List<List<Integer>> adj, boolean[] visited) {
        if(adj.get(course).isEmpty()) {
            return true;
        }

        if(visited[course]) {
            // course is visited but we came here again
            return false;
        }
        
        visited[course] = true;

        for(int c: adj.get(course)) {
            if(!dfs(c, adj, visited)) {
                return false;
            }
        }

        visited[course] = false;

        adj.get(course).clear();
        return true;
    }
}