package edu.uml.bcabral.stockTraderTests;


import edu.uml.bcabral.stocktrader.StockService;
import edu.uml.bcabral.stocktrader.StockServiceFactory;
import edu.uml.bcabral.stocktrader.StockServiceImplementation;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;

public class StockServiceFactoryTest {

    @Test
    public void testStockServiceFactory(){
        StockServiceFactory ssf = new StockServiceFactory();
        ssf.getClass();
    }
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue(true);
    }

}
