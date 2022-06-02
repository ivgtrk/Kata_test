package com.ivl41;

public class Main {

    public static void main(String[] args) throws Exception
    {
        ExpressionReader er = new ExpressionReader();
        Calculator clc = new Calculator();
        System.out.println((clc.Compute(er.Read())));
    }
}
