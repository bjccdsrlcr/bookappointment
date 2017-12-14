package com.bjccdsrlcr.appoint.test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Author: bjccdsrlcr
 * Date: 2017/12/11 0011
 * Time: 16:44
 *
 */
public class Case4 {
    public static String[] case4(String string){
        String array[] = new String[20];
        ArrayList arrayList = new ArrayList();
        if (string.length()==0){
            array[0]="";
            arrayList.add(0, "");
            return array;
        }
        if (string.length()>0 && string.length()<=8){
            while (string.length()<8){
                string+='0';
            }
            array[0] = string;
            arrayList.add(0, string);
            return array;
        }else{
            int len = string.length();
            int consult = string.length()/8;
            int residue = len%8;
            array[0] = string.substring(0, 8);
            arrayList.add(0, string.substring(0,8));
            for (int i=1;i<consult;i++){
                array[i] = string.substring(8*i, 8*i+8);
                arrayList.add(i, string.substring(8*i, 8*i+8));
            }
            int len1 = len-consult*8;
            if (residue == 0){
                array[consult]=null;
                arrayList.add(consult, "");
            }else {
                String lastString = string.substring(consult*8, consult*8+len1);
                while ((8-residue)>0){
                    lastString+='0';
                    residue++;
                }
                array[consult] = lastString;
                arrayList.add(consult, lastString);
            }
            return array;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String s = scanner.nextLine();
            String s1 = scanner.nextLine();
            String[] aa = case4(s);
            String[] bb = case4(s1);
            for (int i=0; i<aa.length; i++){
                if (aa[i]!=null){
                    System.out.println(aa[i]);
                }
            }
            for (int i=0; i<bb.length; i++){
                if (bb[i]!=null){
                    System.out.println(bb[i]);
                }
            }

    }
}
