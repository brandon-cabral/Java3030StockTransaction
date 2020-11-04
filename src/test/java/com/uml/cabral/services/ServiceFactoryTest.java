package com.uml.cabral.services;

import com.uml.cabral.services.PersonService;
import com.uml.cabral.services.ServiceFactory;
import com.uml.cabral.services.StockService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>ServiceFactory</CODE>
 */
public class ServiceFactoryTest {

    @Test
    public void testGetStockServiceInstance() {
        StockService stockService = ServiceFactory.getStockServiceInstance();
        assertNotNull(stockService);
    }

    @Test
    public void testGetPersonServiceInstance(){
        PersonService personService = ServiceFactory.getPersonServiceInstance();
        assertNotNull(personService);
    }
}
