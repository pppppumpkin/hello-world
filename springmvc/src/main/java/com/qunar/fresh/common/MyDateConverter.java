package com.qunar.fresh.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liyingsong on 16-6-14.
 */
public class MyDateConverter implements Converter<String, Date>{
    private static Logger logger = LoggerFactory.getLogger(MyDateConverter.class);

    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
