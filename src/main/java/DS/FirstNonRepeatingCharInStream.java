package org.DSA;

import java.util.Arrays;

public class FirstNonRepeatingCharInStream {

    public static String FirstNonRepeating(String A)
    {
        char firstNonRepeatingChar='\0';
        String ans="";
        int freq[] = new int[26];
        Arrays.fill(freq,0);
        for(Character ch : A.toCharArray())
        {
            System.out.println(freq[ch-'a']);
            if(freq[ch-'a'] == 0)
            {
                freq[ch-'a']=1;
            }
            else
            {
                freq[ch-'a']+=1;
            }

            if(firstNonRepeatingChar == '\0')
            {
                firstNonRepeatingChar = ch;
            }
            else {
                if(freq[firstNonRepeatingChar -'a'] > 1)
                {
                    firstNonRepeatingChar = '#';
                }
                else {

                }
            }
            ans+=firstNonRepeatingChar;

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(FirstNonRepeating("aabc"));
    }
}
