class Solution {
    public int minSideJumps(int[] obstacles) {
        int n =  obstacles.length;
        int [][]dp = new int [4][n];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length;j++){
                dp[i][j] = -1;
            }
        }

        return solve(obstacles, 2, 0,dp);
    }

    public int solve(int []obstacles, int curlane, int curposition, int [][]dp){
        if(curposition == obstacles.length-1){
            return 0;
        }

        if(dp[curlane][curposition] != -1){
            return dp[curlane][curposition];
        }

        int ans = Integer.MAX_VALUE;

        if(obstacles[curposition+1] != curlane){
            return solve(obstacles, curlane, curposition+1 ,dp);
        }else{
            for(int i=1;i<=3;i++){
                if((curlane != i) && (obstacles[curposition] != i)){
                    ans = Math.min(ans, 1+solve(obstacles, i, curposition,dp));
                } 
            }
        }
        dp[curlane][curposition] = ans;
        return dp[curlane][curposition];
    }
}
