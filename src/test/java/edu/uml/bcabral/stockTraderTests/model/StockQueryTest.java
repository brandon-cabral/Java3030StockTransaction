package edu.uml.bcabral.stockTraderTests.model;

import edu.uml.bcabral.stocktrader.model.StockQuery;
import edu.uml.bcabral.stocktrader.model.StockSymbolType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for StockQuery Class
 */
public class StockQueryTest {

    @Test
    public void testBasicConstruction() throws Exception{
        String symbol = "APPL";
        StockQuery stockQuery = new StockQuery(symbol,"2010/11/11","2011/11/11");
        assertEquals("Verify construction", symbol, stockQuery.getSymbol());
    }

}
