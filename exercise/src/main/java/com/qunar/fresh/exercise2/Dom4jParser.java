package com.qunar.fresh.exercise2;

import org.dom4j.*;
import org.dom4j.io.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Created by liyingsong on 16-5-15.
 */
public class Dom4jParser<T> implements Parser<T> {
    private static String className;
    @Override
    public Document createNewXml(String xmlPath, String propertyPath) {
        Document document = createDocument(xmlPath);
        Properties property = createProperty(propertyPath);
        return replace(document, property);
    }

    @Override
    public T createObject(Document doc, T anyType) {
        if (null == doc)
            return anyType;
        T result;
        try {
            result = (T) anyType.getClass().newInstance(); //InstantiationException IllegalAccessException
            List nodes = doc.getRootElement().elements("property");
            for(Iterator it = nodes.iterator(); it.hasNext(); ) {
                Element ele = (Element)it.next();
                String paramName = ele.attribute("name").getValue();
                String paramValue = ele.element("value").getText();
                Field f = null;
                try {
                    f = anyType.getClass().getDeclaredField(paramName);
                } catch (NoSuchFieldException e) {
                    //log
                    return anyType;
                }
                f.setAccessible(true);
                String typeName = f.getType().getName();
                if(typeName.equals("String"))
                    f.set(result, paramValue);  //IllegalAccessException
                else if(typeName.equals("int"))
                    f.setInt(result, Integer.parseInt(paramValue));
                else if(typeName.equals("Date"))
                    try {
                        f.set(result, new SimpleDateFormat("yyyy-MM-dd").parse(paramValue));
                    } catch (ParseException e) {
                        //log
                    }
                else if(typeName.equals("boolean"))
                    f.setBoolean(result, Boolean.parseBoolean(paramValue));
                else if(typeName.equals("char"))
                    f.setChar(result, paramName.charAt(0));
                else if(typeName.equals("byte"))
                    f.setByte(result, Byte.parseByte(paramName));
                else if(typeName.equals("short"))
                    f.setShort(result, Short.parseShort(paramValue));
                else if(typeName.equals("long"))
                    f.setLong(result, Long.parseLong(paramValue));
                else if(typeName.equals("float"))
                    f.setFloat(result, Float.parseFloat(paramValue));
                else if(typeName.equals("double"))
                    f.setDouble(result, Double.parseDouble(paramValue));
            }
        } catch (InstantiationException e) {
            //log
            return anyType;
        } catch (IllegalAccessException e) {
            //log
            return anyType;
        }
        return result;
    }

    protected Document createDocument(String xmlPath) {
        SAXReader reader = new SAXReader();
        try {
            return reader.read(new File(xmlPath));
        } catch (DocumentException e) {
            //log
            return null;
        }
    }
    protected Properties createProperty(String propertyPath) {
        Properties property = new Properties();
        try {
            property.load(new FileInputStream(propertyPath));
            return property;
        } catch (IOException e) {
            //log
            return null;
        }
    }

    protected Document replace(Document document, Properties property) {
        if (document == null || property == null)
            return null;
        Element rootEle = document.getRootElement();
        className = rootEle.attribute("class").getValue();
        for (Iterator iterator = rootEle.elementIterator(); iterator.hasNext(); ) {
            Element ele = (Element) iterator.next();
            String key = ele.attribute("name").getValue();
            String value = property.getProperty(key);
            ele.element("value").setText(value);
        }
        return document;
    }

}
