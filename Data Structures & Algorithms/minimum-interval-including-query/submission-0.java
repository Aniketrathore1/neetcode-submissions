class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals , (a,b)->a[0]-b[0] );
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];

        for(int i = 0 ; i < m ; i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries , (a,b)->a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                if(a[0] == b[0]){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        );

        int[] ans = new int[m];
        Arrays.fill(ans , -1);
        int i = 0;

        for(int[]  q : sortedQueries){
            int query = q[0];
            int idx = q[1];

            while(i < intervals.length && intervals[i][0] <= query){
                int start = intervals[i][0];
                int end = intervals[i][1];
                int len = end - start + 1;
                pq.offer(new int[]{len , end});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < query){
                pq.poll();
            }

            if(!pq.isEmpty()){
                ans[idx] = pq.peek()[0];
            }
        }
        return ans;
 
    }
}
