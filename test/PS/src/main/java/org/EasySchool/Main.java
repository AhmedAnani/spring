package org.EasySchool;


import java.io.BufferedReader;
import java.nio.Buffer;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int u = scanner.nextInt();
        int[]ar=new int[u];
        int num;
        for(int i=0;i<u;i++){
            num= scanner.nextInt();
            ar[i]=num;
        }
        int x= scanner.nextInt();
        for (int i=0;i<u;i++){
            if(ar[i]==x){
                System.out.println(i);
                break;
            }if(i==u-1){
                System.out.println(-1);
            }
        }
 scanner.close();
    }
}
