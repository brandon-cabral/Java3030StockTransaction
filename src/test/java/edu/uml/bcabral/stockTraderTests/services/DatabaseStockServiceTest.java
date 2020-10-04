package edu.uml.bcabral.stockTraderTests.services;

import edu.uml.bcabral.stocktrader.model.StockQuote;
import edu.uml.bcabral.stocktrader.model.StockSymbolType;
import edu.uml.bcabral.stocktrader.services.DatabaseStockService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest {

    @Test
    public void testGetQuote() throws Exception {
        DatabaseStockService databaseStockService = new DatabaseStockService();
        StockSymbolType symbol = StockSymbolType.valueOf("APPL");
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }
}
