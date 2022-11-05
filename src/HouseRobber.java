class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length -1), helper(nums, 1, nums.length));
    }

    public int helper(int []nums, int start, int end){
        int prevTwo = 0, prevOne = 0 , max = 0;
        for(int i = start; i< end; i++){
            max = Math.max(prevTwo + nums[i] , prevOne);
            prevTwo = prevOne;
            prevOne = max;
        }
        return max;

    }
}
