package controller;

import model.Currency;
import model.CurrencyService;
import view.ConverterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterController {
    private CurrencyService currencyService;
    private ConverterView converterView;

    public CurrencyConverterController(CurrencyService currencyService, ConverterView converterView) {
        this.currencyService = currencyService;
        this.converterView = converterView;

        this.converterView.addConvertButtonListener(new ConvertButtonListener());
    }

    class ConvertButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            double amount;
            double amountAfterConversion;
            Currency currencyFrom = null;
            Currency currencyTo = null;

            amount = converterView.getAmount();
            currencyFrom = currencyService.findCurrencyByCurrencyName(converterView.getCurrencyNameFrom());
            currencyTo = currencyService.findCurrencyByCurrencyName(converterView.getCurrencyNameTo());
            if (amount < 0) {
                converterView.setAmountAfterConversion("Wprowadziłeś błędną kwotę.");
            } else {
                amountAfterConversion = currencyService.currencyConversion(amount, currencyFrom, currencyTo);
                amountAfterConversion = Math.round(100 * amountAfterConversion) / 100.0;
                converterView.setAmountAfterConversion(String.valueOf(amountAfterConversion));
            }
        }
    }

}
