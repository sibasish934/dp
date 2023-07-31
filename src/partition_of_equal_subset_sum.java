//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for( int i=0; i< arr.length; i++){
            sum = sum + arr[i];
        }
        int [][]dp = new int [arr.length+1][(sum/2)+1];
        for( int i = 0; i< dp.length; i++){
            for( int j =0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        if(sum % 2 != 0 ){
            return 0;
        }
        int target = sum /2;
       return solve(0,arr,target, dp);
    }
    
    public static int solve(int index, int []arr, int target, int [][]dp){
        if(target < 0){
            return 0;
        }
        
        if(target == 0){
            return 1;
        }
        
        if(index >= arr.length){
            return 0;
        }
        
        if( dp[index][target] != -1){
            return dp[index][target];
        }
        
        int include = solve(index +1, arr, target-arr[index], dp);
        int exclude = solve(index+1, arr, target - 0, dp);
        
        dp[index][target] = Math.max(include,exclude);
        return dp[index][target];
    }
}
