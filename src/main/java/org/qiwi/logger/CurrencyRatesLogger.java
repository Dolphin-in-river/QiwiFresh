package org.qiwi.logger;

import lombok.NoArgsConstructor;
import org.qiwi.entity.CurrencyRate;

@NoArgsConstructor
public class CurrencyRatesLogger {
    public static void printCurrencyRate(CurrencyRate rate) {
        System.out.println(rate.getCode() + " (" + rate.getName() + ") : " + rate.getValue());
    }
}
