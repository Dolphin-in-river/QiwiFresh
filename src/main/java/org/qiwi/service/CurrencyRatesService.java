package org.qiwi.service;

import org.qiwi.entity.CommandLineArguments;
import org.qiwi.entity.CurrencyRate;
import org.qiwi.exception.CurrencyRateNotFoundException;

public interface CurrencyRatesService {
    CurrencyRate getRate(CommandLineArguments arguments) throws CurrencyRateNotFoundException;
}
