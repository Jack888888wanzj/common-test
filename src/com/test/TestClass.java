package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import javax.swing.text.html.HTMLDocument;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.*;

public class TestClass {

    public static void main(String args[]) {
        main5();
        main4();
        main3();
        Map<String, Object> params = new HashMap<>();
        params.put("communityName", "松霞新苑北小区");
        params.put("areaCode", "23008857");

        List<Map<String, Object>> paramsList = new ArrayList<>();
        paramsList.add(params);

        params = new HashMap<>();
        params.put("communityName", "银河名都");
        params.put("areaCode", "23008857");
        paramsList.add(params);

        Map<String, Object> params2 = new HashMap<>();
//        params2.put("paramList", paramsList);
        params2.put("paramList", JSON.toJSONString(paramsList));


        List<Map<String, Object>> aa = (List<Map<String, Object>>) JSONObject.parse(params2.get("paramList").toString());
//        List<Map<String, Object>> aa = (List<Map<String, Object>>)params2.get("paramList");
        aa.forEach(s->{
            System.out.println(s.get("communityName"));
            System.out.println(s.get("areaCode"));
        });


        LinkedHashMap<String,Object> ss=new LinkedHashMap<>();
        ss.putAll(params);
        ss.putAll(params);

        Map<String, Object> params3 = new HashMap<>();
        params3.put("paramList", ss);

        LinkedHashMap<String,Object> bb = (LinkedHashMap<String,Object>)params3.get("paramList");
        aa.forEach(s1->{
            System.out.println(s1.get("communityName"));
            System.out.println(s1.get("areaCode"));
        });


    }


    public static List main2() {
        double a=23.344;
        double b=23.544;
        int c=1234;
        int d=1236;

        System.out.println(String.format("%.1f",Double.valueOf(c)/100));
        System.out.println(String.format("较上月降%.1f", Double.valueOf(d)/100)+"%");

        BigDecimal a1 = new BigDecimal(a);

        System.out.println(a1.setScale(0, BigDecimal.ROUND_DOWN).toString());
        System.out.println("㎡");

        BigDecimal b1 = new BigDecimal(b);

        System.out.println(b1.setScale(0, BigDecimal.ROUND_DOWN).toString());


        return null;
    }

    public static List main3() {

        Float c =  12.34f;
        Float d =  12.36f;
        Float e =  12.0f;
        float c1 =  12.34f;
        float d1 =  12.36f;
        float e1 =  12.0f;
        System.out.println(c.intValue());
        System.out.println(d.intValue());

        System.out.println(e.intValue()==e);

        List<String> list = Lists.newArrayList();
        List<String> list2 = Lists.newArrayList();
        list.add("1");
        list.add("b");
        list.add("c");
        Long a=1L;
        for (String s : list) {
            if(a.toString().equals(s))
            {
                list2.add(s);
                break;
            }
        }


        return null;
    }


    public static List main4() {


        int f =10;
        Integer f1=10;
        System.out.println(f==f1);
        int f2=f1;
        System.out.println(f2);
        BigDecimal a=new BigDecimal(122403);
        BigDecimal a1=new BigDecimal(125603);
        BigDecimal b=new BigDecimal(10000);

        BigDecimal c=a.divide(b);
        BigDecimal c1=a1.divide(b);
        BigDecimal d=new BigDecimal(1.24403);
        BigDecimal d1=new BigDecimal(1.24503);
        System.out.println(c.toString());
        System.out.println(d.setScale(2,BigDecimal.ROUND_UP));
        System.out.println(d1.setScale(2,BigDecimal.ROUND_UP));
        System.out.println(d.setScale(2,BigDecimal.ROUND_DOWN));
        System.out.println(d1.setScale(2,BigDecimal.ROUND_DOWN));
        System.out.println(d.setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println(d1.setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println(d1.setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println(d.setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println(c.intValue());
        System.out.println(c.floatValue());

        System.out.println(c1);
        System.out.println(c1.intValue());
        System.out.println(c1.setScale(0, BigDecimal.ROUND_DOWN).toString());

        return null;
    }

    public static void main5()
    {

        LocalDateTime syncTime = LocalDateTime.now();
        System.out.println(syncTime.getYear()+" "+syncTime.getMonthValue()+" "+syncTime.getDayOfMonth());
        Date changeDate = new GregorianCalendar(syncTime.getYear(),syncTime.getMonthValue()-1,syncTime.getDayOfMonth()).getTime();
        // 封装结果
        System.out.println(changeDate.getYear());
        System.out.println(changeDate.getMonth());
        System.out.println(changeDate.getDay());
        List a = null;
        long count = a.stream().filter(b -> b == null).count();
        System.out.println(count);

    }
}
