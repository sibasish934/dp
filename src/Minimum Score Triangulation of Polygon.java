class Solution {
    public int minScoreTriangulation(int[] values) {
        int [][]dp = new int [values.length][values.length];
        for(int i=0;i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        int n = values.length;
        return solve(values, 0, n-1,dp);
    }

    public int solve(int []v, int i, int j,int [][]dp){
        if(i+1 == j){
            return 0; // as only two points are there so triangle formation is not possible.
        }
        if( dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for( int k = i + 1; k < j ; k++){
            ans = Math.min( ans , v[i]*v[j]*v[k] +solve(v,i,k,dp)+solve(v,k,j,dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }


}
