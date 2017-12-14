package com.bjccdsrlcr.appoint.test;

import java.util.Scanner;

/**
 * Author: bjccdsrlcr
 * Date: 2017/12/11 0011
 * Time: 14:26
 */
public class number1 {
    public static int lastNumber(String string){
        String aa[] = string.split(" ");
        int len = aa.length;
        System.out.println(aa[len-1]);
        String b = aa[len-1];
        return b.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            int len = lastNumber(str);
            System.out.println(len);
        }
    }
}
