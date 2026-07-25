class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        rotate(nums , 0 , nums.length-1);
        rotate(nums , 0 , k - 1);
        rotate(nums , k , nums.length - 1);
    }
    private void rotate(int[] nums , int left , int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}