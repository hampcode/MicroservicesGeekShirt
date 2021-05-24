package com.geekshirt.shippingservice.util.enums;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date addDays(Date aDate, int numberOfDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(aDate);

        cal.add(Calendar.DATE, numberOfDays);

       return cal.getTime();
    }
}
