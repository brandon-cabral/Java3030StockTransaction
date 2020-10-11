package edu.uml.bcabral.stockTraderTests.services;

import edu.uml.bcabral.stocktrader.services.PersonService;
import edu.uml.bcabral.stocktrader.services.ServiceFactory;
import edu.uml.bcabral.stocktrader.services.StockService;
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
