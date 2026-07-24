class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b - a);


        for(int num : nums){
            pq.offer(num);
        }

        int count = 0;
        while(count < k - 1){
            pq.poll();
            count++;
        }

        return pq.peek();
    }
}
