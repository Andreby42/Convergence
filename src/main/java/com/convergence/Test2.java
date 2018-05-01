package com.convergence;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test2 {
    // 一个球 从100 米自由落下，每次反弹至原高处的一半，再落下，求它在第10次落地的时候，共经过多少米，第10次反弹多高。
    public static void main(String[] args) throws ParseException {
        double sum = 100;// 总里程 初始值。 第二次开始每次里程的都是上次的里程 将每次第一次触底和第二次触底作为循环
        double x = 50;// 起跳位置。将第二次起跳位置作为开始循环位置，触底后和下次触底作为循环
        for (int i = 2; i <= 10; i++) {
            sum += (x * 2);
            x = x / 2;
            System.out.println("总里程" + sum);
            System.out.println("当前高度" + x);
        }
        //计算随机指定的某年的某月份的天数和周数
        try {
            doCaculateDate("2018-12","yyyy-mm");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void doCaculateDate(String source,String partern) throws Exception {
        try {
            Calendar instance = Calendar.getInstance();
            DateFormat df=new SimpleDateFormat(partern);
             Date date =df.parse(source);
            instance.setTime(date);
            int weeks = instance.getActualMaximum(Calendar.WEEK_OF_MONTH);
            int days = instance.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println(weeks);
            System.out.println(days);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("计算出错。；",e);
        }
    }

}
