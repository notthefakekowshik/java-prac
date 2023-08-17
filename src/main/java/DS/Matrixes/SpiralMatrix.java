package org.DSA.Matrixes;

import java.util.ArrayList;

public class SpiralMatrix {

    public static void main(String[] args) {
        int a[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int r = 4;
        int c = 4;
        int left = 0;
        int right = c-1;
        int top = 0;
        int down = r-1;
        ArrayList<Integer> al = new ArrayList<Integer>();
        while(left <= right && top <= down)
        {
            for(int i=left;i<=right;i++)
            {
                al.add(a[top][i]);
            }
            top+=1;
            for(int i=top;i<=down;i++)
            {
                al.add(a[i][right]);
            }
            right-=1;
            if(top <= down)
            {
                for(int i = right; i >= left;i--)
                {
                    al.add(a[down][i]);
                }
                down-=1;
            }

            if(left <= right)
            {
                for(int i =down; i >= top ;i--)
                {
                    al.add(a[i][left]);
                }
                left+=1;
            }
        }
        al.stream().forEach(val-> System.out.println(val + " "));
    }
}
