class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles){
            right = Math.max(right , pile);
        }

        int minSpeed = right;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(canEatAll(piles , h , mid)){
                minSpeed  = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }   
        return minSpeed; 
    }
    private boolean canEatAll(int[] piles , int hour , int bananaToEat){
        long totalHour = 0;

        for(int pile : piles){
            totalHour += (pile + bananaToEat - 1)/bananaToEat;
        }
        return totalHour <= (long) hour;
    }
}
