package com.ivl41;
import java.util.*;

class Calculator
{
    String[] roman = {"n","i","ii","iii","iv","v","vi","vii","viii","ix","x"};
    char[] operator = {'+','-','*','/'};

    public String Compute(String[] array) throws Exception {
        NumType ntFirst = GetNumType(array[0]);
        if(ntFirst != GetNumType(array[2]))
            throw new Exception("Number's types not equality!");

        int a = GetNumeric(array[0]);
        int b = GetNumeric(array[2]);
        int res = 0;

        Arrays.sort(operator);
        int OpIdx = Arrays.binarySearch(operator, array[1].toCharArray()[0]);
        if(OpIdx < 0)
            throw new Exception("Unknown operator!");

        switch (operator[OpIdx]){
            case '+': res = a + b; break;
            case '-': res = a - b; break;
            case '*': res = a * b; break;
            case '/': res = a / b; break;
        }
        if(ntFirst == NumType.Arabic)
            return Integer.valueOf(res).toString();

        IntegerConverter converter = new IntegerConverter();
        String rom = converter.intToRoman(res);
        if(rom == null)
            throw new Exception("The Roman number cannot be < 1!");
        return rom;
    }

    private static int indexOfArray(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            if (key.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }
    private int GetNumeric(String s) throws Exception {
        int ret;
        if(GetNumType(s) == NumType.Arabic)
            ret = Integer.parseInt(s);
        else if(GetNumType(s) == NumType.Roman)
            ret = indexOfArray(roman, s.toLowerCase());
        else
            throw new Exception("The number is unknown type!");
        if(ret < 0 || ret > 10)
            throw new Exception("The number out of range!");
        return ret;
    }
    private NumType GetNumType(String s){
        NumType nt = NumType.Unknown;
        try {
            Integer.parseInt(s);
            nt = NumType.Arabic;
        } catch (NumberFormatException e) {
            int n = indexOfArray(roman, s.toLowerCase());
            if(n != -1)
                nt = NumType.Roman;
        }
        return nt;
    }
}
