class Solution {
    public int lengthOfLIS(int[] nums) {
        int [][]dp = new int [nums.length][nums.length+1];
        for( int i=0; i<dp.length; i++){
            for(int j =0; j < dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        return solve(nums, dp, -1, 0);
    }

    public int solve(int []nums,int [][]dp, int prev, int curr){
        if(curr == nums.length){
            return 0;
        }

        if(dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }
        int take =0;
        int nottake = 0;
        if(prev == -1 || nums[curr] > nums[prev]){
            take = 1 + solve(nums, dp, curr, curr+1);
        }

        nottake = 0 + solve(nums, dp, prev , curr+1);
        dp[curr][prev+1] = Math.max(take, nottake);
        return dp[curr][prev+1];
    }
}
