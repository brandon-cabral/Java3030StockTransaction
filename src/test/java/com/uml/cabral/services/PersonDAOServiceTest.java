package com.uml.cabral.services;

import com.uml.cabral.services.PersonService;
import com.uml.cabral.services.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PersonDAOServiceTest {

    @Test
    public void testStockService(){
        PersonService serviceFactory = ServiceFactory.getPersonServiceInstance();
        assertNotNull(serviceFactory);      //verify servicefactory is not null
    }
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue(true);
    } //always true
}
