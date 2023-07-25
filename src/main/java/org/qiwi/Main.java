package org.qiwi;

import org.qiwi.entity.CurrencyRate;
import org.qiwi.exception.CurrencyRateNotFoundException;
import org.qiwi.logger.CurrencyRatesLogger;
import org.qiwi.service.CommandLineParseService;
import org.qiwi.service.CurrencyRatesServiceImpl;

public class Main {
    public static void main(String[] args) throws CurrencyRateNotFoundException {
        CurrencyRate rate = new CurrencyRatesServiceImpl().getRate(CommandLineParseService.parseArguments(args));
        CurrencyRatesLogger.printCurrencyRate(rate);
    }
}