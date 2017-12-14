package com.bjccdsrlcr.appoint.test;

/**
 * Author: bjccdsrlcr
 * Date: 2017/12/11 0011
 * Time: 14:54
 */
import java.util.Scanner;
public class Main{
    public static int case2(String str, String a){
        String array[] = str.split("");
        int count = 0;
        for(int i = 0; i<array.length; i++){
            if(array[i].equals(a)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
//        Scanner scanner1 = new Scanner(System.in);
//        String str = scanner1.next();
//        Scanner scanner2 = new Scanner(System.in);
//        String a = scanner2.next();
//        char c = a.charAt(0);
        int count = case2("sdasd", "a");
        System.out.print(count);
    }
}