class Solution {
    int[] order;
    int[] added;
    int idx = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order = new int[numCourses];
        added = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, adj, visited)) {
                return new int[]{};// found a cycle, therefore not possible to generate the order of courses
            }
        }

        return order;
    }

    public boolean dfs(int course, List<List<Integer>> adj, boolean[] visited) {
        if(added[course] == 1) {
            return true;
        }

        if(adj.get(course).isEmpty()) {
            order[idx++] = course;
            added[course] = 1;
            return true;
        }

        if(visited[course]) {
            return false; 
        }

        visited[course] = true;

        for(int c: adj.get(course)) {
            if(!dfs(c, adj, visited)) {
                return false;
            }
        }

        adj.get(course).clear();
        order[idx++] = course;
        added[course] = 1;

        return true;
    }
}