package edu.uml.bcabral.stockTraderTests;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Test class called StockTransactionTest that will run various test to ensure each function
 * and class works as it should.
 *
 */

import edu.uml.bcabral.stocktrader.StockSymbolType;
import edu.uml.bcabral.stocktrader.StockTransaction;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;



public class StockTransactionTest {

    @Test
    public void testStockTransaction() {
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction stockTransaction = new StockTransaction(new BigDecimal(100), StockSymbolType.APPL, timestamp);
        assertNotNull(stockTransaction);
    }
    @Test
    public void testGetPrice(){     //verify price not null
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction stockTransaction = new StockTransaction(new BigDecimal(100), StockSymbolType.APPL, timestamp);
        assertNotNull(stockTransaction.getPrice());
    }
    @Test
    public void testGetStockSymbol(){   //verify stock symbol not null

        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction stockTransaction = new StockTransaction(new BigDecimal(100), StockSymbolType.APPL, timestamp);
        assertNotNull(stockTransaction.getStockSymbol());
    }
    @Test
    public void testGetTime(){      //verify time not null
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction stockTransaction = new StockTransaction(new BigDecimal(100), StockSymbolType.APPL, timestamp);
        assertNotNull(stockTransaction.getTime());
    }
    @Test
    public void testToString(){     //verify toString not null
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction stockTransaction = new StockTransaction(new BigDecimal(100), StockSymbolType.APPL, timestamp);
        assertNotNull(stockTransaction.toString());
    }
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue(true);
    }   //always true

}
