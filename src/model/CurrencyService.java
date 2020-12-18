package model;

import java.net.MalformedURLException;
import java.net.URL;

public class CurrencyService {
    private ExchangeRate exchangeRate;

    public CurrencyService() {
        this.update();
    }

    private void update() {
        try {
            URL url = new URL("https://www.nbp.pl/kursy/xml/lasta.xml");
            ExchangeRateXmlParser parser = new ExchangeRateXmlParser();
            exchangeRate = parser.parseExchangeRate(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String[] getListCurrencyNames() {
        String[] listCurrencyCodes = new String[exchangeRate.getCurrencies().size()+1];
        int i = 0;
        for (Currency currency: exchangeRate.getCurrencies()) {
            listCurrencyCodes[i] = currency.getCurrencyName();
            i++;
        }
        listCurrencyCodes[i] = "złoty";
        //Arrays.sort(listCurrencyCodes);
        return listCurrencyCodes;
    }

    public Currency findCurrencyByCurrencyName(String currencyName) {
        for(Currency currency: exchangeRate.getCurrencies()) {
            if (currencyName.equals(currency.getCurrencyName())) {
                return currency;
            } else if(currencyName.equals("złoty")) {
                return new Currency("złoty", 1, "PLN", 1);
            }
        }
        return null;
    }

    public double currencyConversion(double amount, Currency currencyFrom, Currency currencyTo) {
        return amount * currencyFrom.getAverageExchangeRate() / currencyFrom.getConverter() / currencyTo.getAverageExchangeRate() / currencyTo.getConverter();
    }
}
