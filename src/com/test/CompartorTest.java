package com.test;

import java.util.*;

/**
 * 测试比较器性能
 */
public class CompartorTest {


    static float price=23;

    static List datas = null;
    public static void main(String args[])
    {
        MyPriceComparator myPriceComparator = new MyPriceComparator(price);
        initDatas();
        long start  = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            originMethod(datas,myPriceComparator);
            System.out.println("i===="+i);
        }

        long end =System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }

    public void originMethod(List datas)
    {

    }

    public static void originMethod(List datas2, Comparator c)
    {
//        List a = new ArrayList();
//        a.addAll(datas);

        Collections.sort(datas2,c);


//        a.sort(c);
        System.out.println("originMethod+Comparator-->result:"+datas2);
//        System.out.println("a+Comparator-->result:"+a);
        datas=null;
        initDatas();
    }

    private static void initDatas()
    {
        datas = new ArrayList();
        Random random = new Random();
        for (int i=0;i<100;i++)
        {
            datas.add(random.nextInt(1000));
        }
        System.out.println("datas===:"+datas);
    }

    static class MyPriceComparator implements  Comparator
    {
        private float price;
        public MyPriceComparator(float price)
        {
            this.price = price;
        }
        @Override
        public int compare(Object o1, Object o2) {

            float abs1 = Math.abs((Integer) o1 - price);
            float abs2 = Math.abs((Integer) o2 - price);
            if (abs1>abs2)
                return 1;
            else if(abs1<abs2)
                return -1;
            else
                return 0;
        }
    }
}
