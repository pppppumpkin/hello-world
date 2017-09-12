package com.qunar.fresh.exercise2;

import org.dom4j.Document;

/**
 * Created by liyingsong on 16-5-15.
 */
public interface Parser<T> {
    Document createNewXml(String xmlPath, String propertyPath);
    T createObject(Document doc, T anyType);
}
