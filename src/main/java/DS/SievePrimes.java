package org.DSA;

import java.util.Arrays;

public class SievePrimes {

    public static void main(String[] args) {
        int n =100;
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        for(int i = 2;i*i<=n;i++)
        {
            if(primes[i])
            {
                for(int j = 2*i;j<=n;j+=i)
                {
                    primes[j]=false;
                }
            }
        }
        for(int i = 0;i<=n;i++)
        {
            if(primes[i])
            {
                System.out.print(i+" ");
            }
        }

    }
}
