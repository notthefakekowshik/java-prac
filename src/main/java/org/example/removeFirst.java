package org.example;

import org.apache.commons.lang3.StringUtils;

public class removeFirst {

    public static void main(String[] args) {
        String filterName = "%exampl%e";
        filterName = StringUtils.removeStart(filterName, "%");

        // Remove the "%" character from the end
        filterName = StringUtils.removeEnd(filterName, "%");

        System.out.println(filterName);
    }
}
