/*
package com.util;

import com.spire.xls.*;
import com.spire.xls.collections.HyperLinksCollection;
*/
/**
 * @Description TODO
 * @ClassName ExcelUtils
 * @Autor wanzj
 * @Date 2021-9-2 9:17
 * @Version 1.0
 *//*

public class ExcelUtils {

    public static void main(String[] args) {
        //加载包含超链接的Excel工作簿
        Workbook wb = new Workbook();
        wb.loadFromFile("AddHyperlink.xlsx");

        //获取工作表
        Worksheet sheet = wb.getWorksheets().get(0);

        //获取超链接集合
        HyperLinksCollection hyperLinks = sheet.getHyperLinks();

        //遍历所有超链接
        for (int i = 0; i< hyperLinks.getCount();i++)
        {
            //获取包含超链接的单元格行、列坐标
            int row = hyperLinks.get(i).getRange().getRow();
            int column = hyperLinks.get(i).getRange().getColumn();

            //获取超链接文本、地址
            String text = hyperLinks.get(i).getTextToDisplay();
            String address = hyperLinks.get(i).getAddress();

            //输出超链接获取结果
            System.out.println(String.format("单元格[%d, %d] 显示文本：" ,row ,column)+ text +"\n"+ " 链接地址："+ address);
        }
}



*/
