//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         int [][]dp = new int [n + 1][w + 1];
         for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < w + 1; j++)
                dp[i][j] = -1;
         
         int ans = solve(w, wt,val,n-1,dp);
         return ans;
    } 
    
    public static int solve(int capacity, int wt[], int value[], int index, int [][]dp){
        if(index == 0){
            if(wt[index]<= capacity){
                return value[index];
            }else{
                return 0;
            }
        }
        
        if(dp[index][capacity] != -1){
            return dp[index][capacity];
        }
        
        int include = 0;
        
        if(wt[index]<= capacity){
            include = value[index] + solve(capacity-wt[index], wt, value, index - 1,dp);
        }
        
        int exclude = 0 + solve(capacity, wt, value,index - 1, dp);
        
        int ans = Math.max(include, exclude);
        return ans;
    }
}


