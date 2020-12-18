package model;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;

public class ExchangeRateXmlParser {
    public ExchangeRate parseExchangeRate(URL url) {
        ExchangeRate exchangeRate = new ExchangeRate();

        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();
            ExchangeRateParserHandler handler = new ExchangeRateParserHandler();
            saxParser.parse(url.openStream(), handler);
            exchangeRate = handler.getExchangeRate();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return exchangeRate;
    }
}
