class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int left = 0;
       int right = 0;

       for(int weight : weights){
        left = Math.max(weight , left);
        right += weight;
       } 
       int ans = right;

       while(left <= right){
        int mid = left + (right - left)/2;

        if(isPossible(weights , days , mid)){
            ans = mid;
            right = mid - 1;
        }else{
            left = mid + 1;
        }
       }
       return ans;
    }
    private boolean isPossible(int[] weights , int days , int capacity){
        int daysNeeded = 1;
        int currentLoad = 0;


        for(int weight : weights){
            if(currentLoad + weight > capacity){
                daysNeeded++;
                currentLoad = weight;
            }else{
                currentLoad += weight;
            }
        }
        return daysNeeded <= days;
    }
}