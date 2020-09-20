package edu.uml.bcabral.stockTraderTests;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Test class called StockServiceImplementationTest that will run various test to ensure each function
 * and class works as it should.
 *
 */

import edu.uml.bcabral.stocktrader.*;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class StockServiceImplementationTest {

    @Test
    public void testStockServiceImplementation(){
        StockService ss = new StockServiceFactory().createStockService();
        ss.getClass();
    }
    @Test
    public void testGetQuoteStockService(){
        StockService ss = new StockServiceFactory().createStockService();

        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        ss.getQuote(StockSymbolType.APPL, timestamp);
        ss.getQuote(StockSymbolType.AMZ, timestamp);
        ss.getQuote(StockSymbolType.GOOG, timestamp);
        ss.getQuote(StockSymbolType.IBM, timestamp);
    }
    @Test
    public void testGetQuoteList(){
        StockService ss = new StockServiceFactory().createStockService();
        List<StockTransaction> list = new ArrayList<>();
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction st = ss.getQuote(StockSymbolType.APPL, timestamp);
        list.add(st);

    }
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue(true);
    }


}
