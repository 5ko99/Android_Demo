package com.example.aoc.numbersystemconvert.Convert;

/**
 * Created by aoc on 22.03.16.
 */
public class arr {
    public static char[] reverse(char[] arr){

        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return arr;
    }
}
