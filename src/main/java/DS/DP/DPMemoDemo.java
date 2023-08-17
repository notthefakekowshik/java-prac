package org.DSA.DP;

import java.util.Arrays;

public class DPMemoDemo {

    public static int BottomToUphelper(int n, int dp[]){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(dp[n] == -1){
            dp[n] = BottomToUphelper(n-1,dp) + BottomToUphelper(n-2,dp);
            return dp[n];
        }
        else{
            return dp[n];
        }
    }
    public static int TopToBottomHelper(int n , int dp[]){
        dp[0]=0;
        dp[1]=1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int worstHelper(int n ){
        if( n == 0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return worstHelper(n-1) + worstHelper(n-2);
    }
    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        System.out.println(TopToBottomHelper(n,dp));
        System.out.println("Im the worst " + worstHelper(10));
        Arrays.stream(dp).forEach(value -> System.out.print(value+ " "));
    }
}
