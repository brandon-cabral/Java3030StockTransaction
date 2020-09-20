package edu.uml.bcabral.stockTraderTests;

import edu.uml.bcabral.stocktrader.StockServiceFactory;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;

public class StockServiceTest {

        @Test
        public void testStockService(){
            StockServiceFactory ss = new StockServiceFactory();
            ss.createStockService();
            ss.getClass();
        }
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue(true);
    }









}
