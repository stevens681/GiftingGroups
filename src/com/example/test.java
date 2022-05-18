package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static com.example.Result.countGroups;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'countGroups' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY related as parameter.
     */

    public static int countGroups(List<String> related) {
        // Write your code here
        int count=0;
        if(related==null||related.isEmpty())return 0;

        int[][] linked= new int[related.size()][related.size()];

        for(int i =0; i<related.size(); i++){
            String row = related.get(i);
            for(int j=0; j<row.length(); j++){
                linked[i][j]=Integer.parseInt(Character.toString(row.charAt(j)));
            }
        }

        boolean[] found = new boolean[linked.length];
        for(int i = 0; i<linked.length; i++){
            if(!found[i]){
                checkGroup(linked, found, i);
                count++;
            }
        }
        return count;


    }
    private static void checkGroup(int[][] linked, boolean[] found, int c){
        found[c] = true;

        for(int i = 0; i<linked.length; i++){
            if(linked[c][i]==1 && !found[i]) {
                checkGroup(linked, found, i);
            }

        }
    }
}



//}

public class test {
    //public class Solution {
    public static void main(String[] args) throws IOException {
       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int relatedCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> related = IntStream.range(0, relatedCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine();
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .collect(toList());
//
//        int result = Result.countGroups(related);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
        String given2[] = {"1100", "1101", "0010", "0010", "0001"}; //2
        String given3[] = {"110", "111", "011"}; //1


        String arr1[] = {"1100", "1110", "0110", "0001"};//2
        String arr2[] = {"10000", "01000", "00100", "00010", "00001"};//5
        String arr3[] = {"1100", "1101", "0010", "0010", "0001"};//2
        String arr4[] = {"1100", "1101", "0010", "0010", "0001"};//2
        String arr5[] = {"11100", "11001", "10100", "00011", "01011"};//1
        String arr6[] = {"11100", "11100", "11100", "00011", "00011"};//2
        String arr7[] = {"10100", "01010", "10100", "01010", "00001"};//3

        List<String> related = Arrays.asList(arr7);
        int result = countGroups(related);
        System.out.println(result);


        //List<String> related = new ArrayList<String>();


    }
}