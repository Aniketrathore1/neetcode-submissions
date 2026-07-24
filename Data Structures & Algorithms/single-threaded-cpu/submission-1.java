class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] newTasks = new int[n][3];

        for(int i = 0 ; i < n ; i++){
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }

        Arrays.sort(newTasks , (a,b) ->a[0] - b[0]);


        PriorityQueue<int[]>pq = new PriorityQueue<>(
            (a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]
        );

        int[] result = new int[n];
        int i = 0 ;
        int idx = 0;

        long time = 0;

        while(idx < n){

            if(pq.isEmpty() && time < newTasks[i][0]){
                time = newTasks[i][0];
            }


            while(i < n && newTasks[i][0] <= time){
                pq.offer(newTasks[i]);
                i++;
            }

            int[] curr = pq.poll();
            result[idx++] = curr[2];
            time += curr[1];
        }

        return result;
    }
}
