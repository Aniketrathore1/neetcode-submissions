class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        PriorityQueue<int[]> minHeapCapital = new PriorityQueue<>((a , b) -> Integer.compare(a[0] , b[0]));
        PriorityQueue<Integer> maxHeapProfit = new PriorityQueue<>((a , b) -> Integer.compare(b , a));


        for(int i = 0 ; i < n ; i++){
            minHeapCapital.offer(new int[]{capital[i] , profits[i]});
        }


        for(int i = 0 ; i < k ; i++){
            while(!minHeapCapital.isEmpty() && minHeapCapital.peek()[0] <= w){
                maxHeapProfit.offer(minHeapCapital.poll()[1]);
            }

            if(maxHeapProfit.isEmpty()) break;

            w += maxHeapProfit.poll();
        }
        return w;
    }
}