package model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class ExchangeRateParserHandler extends DefaultHandler {
    private ExchangeRate exchangeRate = new ExchangeRate();
    private Stack<String> elementStack = new Stack<>();
    private Currency currentCurrency;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);

        if ("pozycja".equals(qName)) {
            Currency currency = new Currency();
            currentCurrency = currency;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();

        if ("pozycja".equals(qName)) {
            Currency currency = currentCurrency;
            exchangeRate.addCurrency(currency);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim().replace(",", ".");

        if (value.length() == 0) {
            return;
        }

        switch (elementStack.peek()) {
            case "numer_tabeli":
                exchangeRate.setTableNumber(value);
                break;
            case "data_publikacji":
                exchangeRate.setPublicationDate(value);
                break;
            case "nazwa_waluty":
                currentCurrency.setCurrencyName(value);
                break;
            case "przelicznik":
                currentCurrency.setConverter(Integer.parseInt(value));
                break;
            case "kod_waluty":
                currentCurrency.setCurrencyCode(value);
                break;
            case "kurs_sredni":
                currentCurrency.setAverageExchangeRate(Float.parseFloat(value));
                break;
        }
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }
}
