package org.qiwi.service;

import lombok.NoArgsConstructor;
import org.qiwi.entity.CommandLineArguments;
import org.qiwi.entity.CurrencyRate;
import org.qiwi.exception.CurrencyRateNotFoundException;

import java.time.LocalDate;

@NoArgsConstructor
public class CurrencyRatesServiceImpl implements CurrencyRatesService {
    public CurrencyRate getRate(CommandLineArguments arguments) throws CurrencyRateNotFoundException {
        CurrencyRatesParser parser = new CurrencyRatesParser();
        try {
            return parser.getCurrencyRate(arguments);
        } catch (CurrencyRateNotFoundException e) {
            System.err.println("Не удалось получить курс валюты: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("Ошибка приложения: " + e.getMessage());
            return null;
        }
    }
}
