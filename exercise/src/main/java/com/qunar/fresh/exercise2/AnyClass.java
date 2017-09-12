package com.qunar.fresh.exercise2;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Created by liyingsong on 16-5-15.
 */
public class AnyClass {
    public Class getAnyClass(String xmlPath) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(xmlPath));
            Element rootEle = document.getRootElement();
            return Class.forName(rootEle.attribute("class").getValue());
        } catch (DocumentException e) {
            //log
            return null;
        } catch (ClassNotFoundException e) {
            //log
            return null;
        }
    }

}
