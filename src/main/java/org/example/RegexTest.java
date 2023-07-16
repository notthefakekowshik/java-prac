package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String files[] = {"formio/components/filetest_v1.js" , "formio/components/fileetest_v2.js" , "formio/components/filetest_v3.html"};

        // Define the regular expression pattern
        String regex = "formio/components/.*te.*";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);	

        // Create a Matcher object
        for(String input : files) {
        	Matcher matcher = pattern.matcher(input);
            // Perform the matching
            if (matcher.matches()) {
                System.out.println("Input string matches the pattern");
            } else {
                System.out.println("Input string does not match the pattern");
            }
        }
    }
}
