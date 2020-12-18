package model;

public class Currency {
    private String currencyName;
    private int converter;
    private String currencyCode;
    private double averageExchangeRate;

    public Currency(String currencyName, int converter, String currencyCode, double averageExchangeRate) {
        this.currencyName = currencyName;
        this.converter = converter;
        this.currencyCode = currencyCode;
        this.averageExchangeRate = averageExchangeRate;
    }

    public Currency() {
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getConverter() {
        return converter;
    }

    public void setConverter(int converter) {
        this.converter = converter;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getAverageExchangeRate() {
        return averageExchangeRate;
    }

    public void setAverageExchangeRate(double averageExchangeRate) {
        this.averageExchangeRate = averageExchangeRate;
    }

}
