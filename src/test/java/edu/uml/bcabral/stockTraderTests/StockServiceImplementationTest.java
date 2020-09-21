package edu.uml.bcabral.stockTraderTests;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Test class called StockServiceImplementationTest that will run various test to ensure each function
 * and class works as it should.
 *
 */

import edu.uml.bcabral.stocktrader.*;
import org.junit.Test;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class StockServiceImplementationTest {

    @Test
    public void testStockServiceImplementation(){
        StockService stockService = StockServiceFactory.createStockService();
        assertNotNull("verify stock service factory returns instance", stockService);   //verify not null
    }
    @Test
    public void testGetQuoteStockService(){
        StockService stockService = StockServiceFactory.createStockService();

        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction stockTransaction1= stockService.getQuote(StockSymbolType.APPL, timestamp);   //generate stockTransactions
        StockTransaction stockTransaction2 = stockService.getQuote(StockSymbolType.AMZ, timestamp);
        StockTransaction stockTransaction3 = stockService.getQuote(StockSymbolType.GOOG, timestamp);
        StockTransaction stockTransaction4 = stockService.getQuote(StockSymbolType.IBM, timestamp);
        assertNotNull("verify getQuote returns price", stockTransaction1.getPrice());   // verify price is not null
        assertNotNull("verify getQuote returns price", stockTransaction2.getPrice());
        assertNotNull("verify getQuote returns price", stockTransaction3.getPrice());
        assertNotNull("verify getQuote returns price", stockTransaction4.getPrice());
        assertNotNull("verify getQuote returns stockSymbol", stockTransaction1.getStockSymbol());   //verify symbol is not null
        assertNotNull("verify getQuote returns stockSymbol", stockTransaction2.getStockSymbol());
        assertNotNull("verify getQuote returns stockSymbol", stockTransaction3.getStockSymbol());
        assertNotNull("verify getQuote returns stockSymbol", stockTransaction4.getStockSymbol());
        assertNotNull("verify getQuote returns time", stockTransaction1.getTime());     //verify time is not null
        assertNotNull("verify getQuote returns time", stockTransaction2.getTime());
        assertNotNull("verify getQuote returns time", stockTransaction3.getTime());
        assertNotNull("verify getQuote returns time", stockTransaction4.getTime());

    }
    @Test
    public void testGetQuoteList(){
        StockService stockService = StockServiceFactory.createStockService();      // new stock service
        List<StockTransaction> list = new ArrayList<>();                        // new array list
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction stockTransaction = stockService.getQuote(StockSymbolType.APPL, timestamp);
        list.add(stockTransaction); //add stocktransaction to list
        assertNotNull(list);    //verify list not null

    }
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue(true);       //should always be true
    }


}
