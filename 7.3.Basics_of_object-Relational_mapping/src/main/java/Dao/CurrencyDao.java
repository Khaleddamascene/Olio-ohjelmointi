package Dao;

import jakarta.persistence.EntityManager;
import Datasource.MariaDbJpaConnection;
import Entity.Currency;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CurrencyDao {

    public double getExchangeRate(String currencyCode) {

        Currency currency = find(currencyCode);

        if (currency == null) {
            throw new IllegalArgumentException("Currency not found: " + currencyCode);
        }

        return currency.getRate();
    }

    public Map<String, Object[]> getAllCurrencyInfo() {

        EntityManager em = MariaDbJpaConnection.getInstance();

        List<Currency> currencies =
                em.createQuery("SELECT c FROM Currency c", Currency.class)
                        .getResultList();

        Map<String, Object[]> result = new HashMap<>();

        for (Currency c : currencies) {
            result.put(c.getCode(), new Object[]{c.getName(), c.getRate()});
        }

        return result;
    }
    public void insertCurrency(Currency currency) {

        EntityManager em = MariaDbJpaConnection.getInstance();

        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }
    public Currency find(String code) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        return em.find(Currency.class, code);
    }
}