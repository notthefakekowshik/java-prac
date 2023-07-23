package org.DSA;

public class TwoSum {

    public static boolean validateTwoSum(int a[] ,int target) {
        for(int i = 0;i<a.length;i++)
        {
            for(int j= i+1;j<a.length;j++)
            {
                if(a[i]+a[j]==target)
                {
                    return true;
                }
            }
        }
        return false;
        /*
            1. Hashmap
            2. Two pointers
         */
    }
    public static void main(String[] args) {

    }
}
