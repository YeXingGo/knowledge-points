package com.zl.design.patterns;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @描述： TODO jdk1.8之后拥有的 时间类
 * @作者: Light
 * @时间: 2019/8/24  22:45
 * @版本：
 */
public class data {
    public static void main(String[] args) {
        //获取当前时间  now 年 月 日
        LocalDate now = LocalDate.now();
        System.out.println(now.toString());

        //调用 of 方法，可以进行设置
        now = LocalDate.of(2018, 10, 1);
        System.out.println(now);

        //获取当前时间  小时 分  秒  毫秒
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);
        System.out.println(now +" " + now1);

        //获取当前时间 年 月 日 小时 分  秒  毫秒
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2.toString().replaceAll("T"," "));
        System.out.println(now2.getYear());
        now2 = LocalDateTime.of(now2.getYear() + 1,now2.getMonth(),now2.getDayOfMonth(),now2.getHour(),now2.getMinute());

        //DateTimeFormatter                                                yyyy-MM-dd HH:mm:ss
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now2.format(dateTimeFormatter);
        System.out.println(format);

        LocalDateTime parse = LocalDateTime.parse(format, dateTimeFormatter);
        System.out.println(parse);
    }
}
