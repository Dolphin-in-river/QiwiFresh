package org.qiwi.utils;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class XmlUtils {
    public static List<Element> getChildElements(Element parent, String name) {
        List<Element> elements = new ArrayList<>();
        NodeList nodes = parent.getElementsByTagName(name);
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            elements.add(element);
        }
        return elements;
    }

    public static String getChildElementText(Element parent, String name) {
        Element child = (Element) parent.getElementsByTagName(name).item(0);
        return child.getTextContent();
    }
}