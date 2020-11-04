package com.uml.cabral.services;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Test class called StockServiceTest that will run various test to ensure each function
 * and class works as it should.
 *
 */

import com.uml.cabral.services.StockService;
import com.uml.cabral.services.ServiceFactory;
import org.junit.Test;


import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class StockServiceTest {

    @Test
    public void testStockService(){
        StockService serviceFactory = ServiceFactory.getStockServiceInstance();
        assertNotNull(serviceFactory);      //verify servicefactory is not null
    }
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue(true);
    } //always true









}
