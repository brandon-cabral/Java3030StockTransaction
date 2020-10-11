package edu.uml.bcabral.stockTraderTests.services;

import edu.uml.bcabral.stockTraderTests.model.PersonTest;
import edu.uml.bcabral.stocktrader.model.Person;
import edu.uml.bcabral.stocktrader.services.PersonService;
import edu.uml.bcabral.stocktrader.services.PersonServiceException;
import edu.uml.bcabral.stocktrader.services.ServiceFactory;
import edu.uml.bcabral.stocktrader.util.DatabaseUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DatabasePersonServiceTest {

    private PersonService personService;

    private void initDB() throws Exception{
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    @Before
    public void setUp() throws Exception{
        initDB();
        personService = ServiceFactory.getPersonServiceInstance();
    }

    @After
    public void tearDown() throws Exception{
        initDB();
    }

    @Test
    public void testAddOrUpdatePerson() throws PersonServiceException {
        Person newPerson = PersonTest.createPerson();
        personService.addOrUpdatePerson(newPerson);
        List<Person> personList = personService.getperson();
        boolean found = false;
        for (Person person  : personList){
            if(person.getLast_name().equals(PersonTest.last_name) && person.getFirst_name().equals(PersonTest.first_name)){
                found = true;
                break;
            }
        }
    }

    @Test
    public void testGetStocksByPerson() throws PersonServiceException{
        Person person = PersonTest.createPerson();
        List<String> stocks = personService.getStockSymbols(person);

        for (String stock : stocks){
            personService.addStockSymbolToPerson(stock, person);
        }
        List<String> stocksList = personService.getStockSymbols(person);
        for (String stock : stocks){
            boolean removed = stocksList.remove(stock);
            assertTrue("Verify that the stock was found on the list", removed);
        }
        assertTrue("verify the list of returned stocks matches what was expected", stocksList.isEmpty());
    }
}
