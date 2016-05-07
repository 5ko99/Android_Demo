package com.example.aoc.numbersystemconvert.Math;


public class Mathemathic {
    public static int pow(int n, int p){
        if(p==0){
            return 1;
        }

        int result=1;

        for(int i=0;i<p;i++){
            result *= n;
        }

        return result;
    }

    public static boolean isBinar(String result) {
        Boolean isBinar = true;
        int n;
        char zero = '0';
        char one = '1';
        char[] arr = result.trim().toCharArray();
        n=result.length();

        for(int i=0;i<n;i++){

            if(arr[i]==zero || arr[i]==one){}
            else{
                isBinar=false;
            }
        }

        return isBinar;
    }

}
