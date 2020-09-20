package edu.uml.bcabral.stockTraderTests;

import edu.uml.bcabral.stocktrader.StockSymbolType;
import edu.uml.bcabral.stocktrader.StockTransaction;
import org.junit.jupiter.api.Test;
import static junit.framework.TestCase.assertTrue;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;



public class StockTransactionTest {

    @Test
    public void testStockTransaction() {
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction sst = new StockTransaction(new BigDecimal(100), StockSymbolType.APPL, timestamp);
        sst.getClass();
    }
    @Test
    public void testGetPrice(){
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction sst = new StockTransaction(new BigDecimal(100), StockSymbolType.APPL, timestamp);
        sst.getPrice();
    }
    @Test
    public void testGetStockSymbol(){

        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction sst = new StockTransaction(new BigDecimal(100), StockSymbolType.APPL, timestamp);
        sst.getStockSymbol();
        sst.getTime();
    }
    @Test
    public void testGetTime(){
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction sst = new StockTransaction(new BigDecimal(100), StockSymbolType.APPL, timestamp);
        sst.getTime();
    }
    @Test
    public void testToString(){
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction sst = new StockTransaction(new BigDecimal(100), StockSymbolType.APPL, timestamp);
        sst.toString();
    }
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue(true);
    }

}
