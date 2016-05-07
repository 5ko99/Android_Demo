package com.example.aoc.numbersystemconvert.Convert;

import com.example.aoc.numbersystemconvert.Math.Mathemathic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class  Decimal {

    public static long ToDecimal(String a) {
        long temp=1;
        long dec =0;
        //String forCount = String.valueOf(a).toString();
        int lenght =  a.length();

        //long[] arr = new long[lenght];
        //int n = 0;

        /*do{
            arr[n]=a%10;
            a/=10;
            n++;
        }
        while (a!=0);*/

        char[] ar = a.toCharArray();

        // Reverse arr
        arr.reverse(ar);

        for(int i=0;i<lenght;i++){
            temp = (ar[i]-'0') * Mathemathic.pow(2, i);
            dec+=temp;
        }


        return dec;
    }
}
