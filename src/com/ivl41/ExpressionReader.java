package com.ivl41;
import java.util.Scanner;

class ExpressionReader
{
    Scanner scn = new Scanner(System.in);

    public String[] Read() throws Exception {
        System.out.print("Input a expression: ");
        String[] ret = new String[3];
        String input = scn.nextLine();
        ret = input.split(" ");
        if(ret.length > 3)
            throw new Exception("Array Length > 3!");
        return  ret;
    }
}
