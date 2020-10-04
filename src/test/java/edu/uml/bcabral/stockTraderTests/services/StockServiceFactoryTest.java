package edu.uml.bcabral.stockTraderTests.services;

import edu.uml.bcabral.stocktrader.services.StockService;
import edu.uml.bcabral.stocktrader.services.StockServiceFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>StockServiceFactory</CODE>
 */
public class StockServiceFactoryTest {

    @Test
    public void testGetInstance() {
        StockService stockService = StockServiceFactory.getInstance();
        assertNotNull(stockService);
    }
}
