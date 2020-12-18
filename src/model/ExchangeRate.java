package model;

import java.util.ArrayList;

public class ExchangeRate {
    private String tableNumber;
    private String publicationDate;
    private ArrayList<Currency> currencies = new ArrayList<>();

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void addCurrency(Currency currency) {
        currencies.add(currency);
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

}
