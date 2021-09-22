package com.test;

/**
 * @Description TODO
 * @ClassName StringTest
 * @Autor wanzj
 * @Date 2021-8-11 15:40
 * @Version 1.0
 */
public class StringTest {

    public static void main(String[] args) {
        int times = 100000;
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i=0;i<times;i++)
        {
            sb.append(String.valueOf(i)).append("%").toString();
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder耗时："+(end-start));

        String s="";
        start = System.currentTimeMillis();
        for (int i=0;i<times;i++)
        {
            s = i+"%";
        }
        end = System.currentTimeMillis();
        System.out.println("简单拼接耗时："+(end-start));

    }
}
