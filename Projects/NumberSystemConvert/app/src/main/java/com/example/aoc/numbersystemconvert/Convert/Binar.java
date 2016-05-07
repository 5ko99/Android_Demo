package com.example.aoc.numbersystemconvert.Convert;

public class Binar {
    public static String ToBinar(long a) {
        String bin="";
        long temp=0;

        do{
            temp = a % 2;
            bin += temp;
            a=a/2;
        }
        while(a!=0);
        StringBuffer buffer = new StringBuffer(bin);
        buffer.reverse();
        bin = buffer.toString();

        return  bin;
    }
}
