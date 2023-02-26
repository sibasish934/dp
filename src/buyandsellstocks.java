class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp=new int[n][2];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(prices, 0, 1, dp);
    }

    public int solve(int []prices, int index, int buy, int [][]dp){
        if(index == prices.length){
            return 0;
        }

        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        // include wala case:-
        if(buy == 1){
            int buyKaro = -prices[index] + solve(prices, index + 1, 0, dp);
            int skipKaro = 0 + solve(prices, index + 1, 1, dp);
            dp[index][buy] = Math.max(buyKaro, skipKaro);
        }else{ //exclude case:-
            int sellKaro = prices[index] + solve(prices, index + 1, 1, dp);
            int skipKaro = 0 + solve(prices, index + 1, 0, dp);
            dp[index][buy] = Math.max(sellKaro, skipKaro);
        }

        return dp[index][buy];

    }
}

// solution using iterative method:-

class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i-1] < prices[i]){
                total += prices[i] - prices[i-1];
            }
        }
        return total;
    }
}
