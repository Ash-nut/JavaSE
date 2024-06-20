package cn.helloworld1999.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Time {
    public static void main(String[] args) {
        LocalDate l  = LocalDate.now();
        System.out.println(l);

        LocalDateTime lt = LocalDateTime.now();
        System.out.println(lt);

        Calendar c = Calendar.getInstance();
        System.out.println(c);

        c.set(Calendar.YEAR, 10000);
        System.out.println(c);
        //略
    }
}
