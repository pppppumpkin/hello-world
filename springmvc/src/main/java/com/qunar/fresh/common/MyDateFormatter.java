package com.qunar.fresh.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by liyingsong on 16-6-14.
 */
public class MyDateFormatter implements Formatter<Date>{
    private static Logger logger = LoggerFactory.getLogger(MyDateFormatter.class);

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return null;
    }
}
