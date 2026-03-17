package org.example;

import View.CurrencyConverterView;
import Datasource.MariaDbConnection;
import Dao.CurrencyDao;

public class CurrencyMain {
    public static void main(String[] args) {
        MariaDbConnection.getConnection();
        CurrencyDao currencyDao = new CurrencyDao();
        double rate = currencyDao.getExchangeRate("USD");
        System.out.println("USD rate: " + rate);
        CurrencyConverterView.launch(CurrencyConverterView.class);
    }
}