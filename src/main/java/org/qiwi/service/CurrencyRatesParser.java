package org.qiwi.service;

import org.qiwi.entity.CommandLineArguments;
import org.qiwi.entity.CurrencyRate;
import org.qiwi.exception.CurrencyRateNotFoundException;
import org.qiwi.utils.XmlUtils;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.time.format.DateTimeFormatter;

public class CurrencyRatesParser {
    private static final String CBR_URL = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    private RestTemplate restTemplate;

    public CurrencyRatesParser() {
        restTemplate = new RestTemplate();
    }

    public CurrencyRate getCurrencyRate(CommandLineArguments arguments)
            throws CurrencyRateNotFoundException, ParserConfigurationException, IOException, SAXException {
        String url = CBR_URL + arguments.getDate().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        String response = restTemplate.getForObject(url, String.class);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse(new InputSource(new StringReader(response)));
        Element root = doc.getDocumentElement();
        for (Element valute : XmlUtils.getChildElements(root, "Valute")) {
            String code = XmlUtils.getChildElementText(valute, "CharCode");
            String name = XmlUtils.getChildElementText(valute, "Name");
            if (code.equals(arguments.getCode())) {
                String valueStr = XmlUtils.getChildElementText(valute, "Value");
                return new CurrencyRate(arguments.getCode(), name, String.valueOf(Double.parseDouble(
                        valueStr.replace(",", "."))));
            }
        }
        throw new CurrencyRateNotFoundException("Валюта с таким кодом не была найдена");
    }
}
