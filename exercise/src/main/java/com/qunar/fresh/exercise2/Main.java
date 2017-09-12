package com.qunar.fresh.exercise2;

import org.dom4j.Document;

/**
 * Created by liyingsong on 16-5-15.
 */


/**
 * Created by HL on 2016/4/26.
 */
public class Main {

    public static final String PROPERTY_PATH = "exercise//src//main//resources//object.properties";
    public static final String XML_PATH = "exercise//src//main//resources//object.xml";

    public static void main(String[] args) {
        AnyClass anyClass = new AnyClass();
        Class c = anyClass.getAnyClass(XML_PATH);
        Dom4jParser parser = new Dom4jParser();
        Document document = parser.createNewXml(XML_PATH, PROPERTY_PATH);
        try {
            parser.createObject(document, c.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

}
