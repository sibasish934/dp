class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int [][]dp =  new int [satisfaction.length + 1][satisfaction.length + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solve(satisfaction, 0, dp, 1);  
    }

    public int solve( int []arr, int index, int [][]dp, int time){
        if( index == arr.length){
            return 0;
        }

        if(dp[index][time] != -1){
            return dp[index][time];
        }

        int include = arr[index] * time + solve(arr, index + 1, dp, time + 1);

        int exclude = 0 + solve(arr, index + 1, dp, time);

        dp[index][time] = Math.max(include, exclude);
        return dp[index][time];
    }

}
