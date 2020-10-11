package edu.uml.bcabral.stockTraderTests.services;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Test class called ServiceFactoryTest that will run various test to ensure each function
 * and class works as it should.
 *
 */


import edu.uml.bcabral.stocktrader.services.StockService;
import edu.uml.bcabral.stocktrader.services.ServiceFactory;

import org.junit.Test;


import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class TestServiceFactory {

    @Test
    public void testStockServiceFactory(){
        StockService serviceFactory = ServiceFactory.getStockServiceInstance();
        assertNotNull("verify stock service factory returns instance", serviceFactory);   //verify not null
    }
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue(true);
    }   //always true

}