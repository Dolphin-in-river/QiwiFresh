import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.qiwi.entity.CommandLineArguments;
import org.qiwi.entity.CurrencyRate;
import org.qiwi.exception.CurrencyRateNotFoundException;
import org.qiwi.service.CurrencyRatesService;
import org.qiwi.service.CurrencyRatesServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CurrencyRatesServiceTest {

    private CurrencyRatesService ratesService;

    @Before
    public void setUp() {
        ratesService = new CurrencyRatesServiceImpl();
    }

    @Test
    public void getRate_usdOnCorrectDate_returnsRate() throws CurrencyRateNotFoundException {
        CurrencyRate rate = ratesService.getRate(new CommandLineArguments("USD",
                LocalDate.of(2003, 2, 26)));

        assertEquals("USD", rate.getCode());
        assertEquals("Доллар США", rate.getName());
        assertEquals("31.5875", rate.getValue());
    }

    @Test(expected = CurrencyRateNotFoundException.class)
    public void getRate_invalidCode_throwsException() throws CurrencyRateNotFoundException {
        ratesService.getRate(new CommandLineArguments("XYZ", LocalDate.now()));

    }
}