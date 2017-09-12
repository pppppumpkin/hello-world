package com.qunar.fresh.exercise2;

import com.qunar.fresh.Student;
import org.dom4j.*;
import org.dom4j.io.*;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liyingsong on 16-5-11.
 */
public class ObjectParser<T> {

    private static String objectProperties = "exercise//src//main//java//com//qunar//fresh//exercise2//object.properties";
    private static String objectXml = "exercise//src//main//java//com//qunar//fresh//exercise2//object.xml";
    private static String className;
    private static HashMap<String, String> properties = new HashMap<String, String>();
    private static Class<?> anyClass;

    public static void main(String[] args) {
        getProperties();
        getObjectParser();
    }

    public static void getProperties() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(objectProperties)));
            String line;
            while(null != (line = br.readLine())) {
                properties.put(line.split("=")[0], line.split("=")[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getObjectParser() {
        Object object;
        try {
            File file = new File(objectXml);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(file);
            Element root = doc.getRootElement();
            Attribute attribute = root.attribute("class");
            className = attribute.getText();
            anyClass = Class.forName(className);
            object = (Object)anyClass.newInstance();
            List nodes = root.elements("property");
            for(Iterator it = nodes.iterator(); it.hasNext(); ) {
                Element ele = (Element)it.next();
                String paramName = ele.attribute("name").getValue();
                Element element = ele.element("value");
                element.setText(properties.get(paramName));
                String paramValue = element.getText();
                Field f = anyClass.getDeclaredField(paramName);
                //System.out.println(f);
                f.setAccessible(true);
                if(f.getType().equals(String.class))
                    f.set(object, paramValue);
                else if(f.getType().equals(int.class))
                    f.set(object, Integer.parseInt(paramValue));
                else if(f.getType().equals(Date.class))
                    f.set(object, new SimpleDateFormat("yyyy-MM-dd").parse(paramValue));

            }
            Field[] fields = anyClass.getDeclaredFields();
            for(Field f : fields) {
                f.setAccessible(true);
                System.out.println(f.get(object));
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
