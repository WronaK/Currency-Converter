import controller.CurrencyConverterController;
import model.CurrencyService;
import model.ExchangeRate;
import model.ExchangeRateXmlParser;
import view.ConverterView;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args){
        CurrencyService currencyService = new CurrencyService();
        ConverterView converterView = new ConverterView(currencyService.getListCurrencyNames());
        CurrencyConverterController currencyConverterController = new CurrencyConverterController(currencyService, converterView);

        converterView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converterView.setVisible(true);


    }
}
