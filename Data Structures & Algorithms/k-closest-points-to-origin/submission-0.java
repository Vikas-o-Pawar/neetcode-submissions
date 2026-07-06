class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Float.compare(a.val, b.val));
        int[][] arr = new int[k][2];

        for(int[] pt : points) {
            float euDist =(float) Math.sqrt((pt[0] * pt[0]) + (pt[1] * pt[1]));
            q.offer(new Pair(euDist, pt));
        }

        int ind = 0;

        while(k > 0) {
            k--;
            Pair p = q.poll();
            arr[ind++] = p.arr;
        }
            
        return arr;
    }

    private class Pair {
        float val;
        int[] arr;

        Pair(float val, int[] arr) {
            this.val = val;
            this.arr = arr;
        }
    }
}