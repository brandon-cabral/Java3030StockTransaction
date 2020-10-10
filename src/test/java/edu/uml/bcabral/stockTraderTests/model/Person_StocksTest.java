package edu.uml.bcabral.stockTraderTests.model;

import edu.uml.bcabral.stocktrader.model.Person;
import edu.uml.bcabral.stocktrader.model.Person_Stocks;
import org.junit.Test;

import static org.junit.Assert.*;

public class Person_StocksTest {

    /**
     * Create a Person_Stocks instance for test data
     */
    public static Person_Stocks createPersonStocksInstance(){
        Person person = PersonTest.createPerson();
        String stockSymbol = "APPL";
        return new Person_Stocks(person,stockSymbol);
    }

    @Test
    public void testGettersAndSetters(){
        Person person = PersonTest.createPerson();
        String stockSymbol = "APPL";
        Person_Stocks personstocks = new Person_Stocks();
        int id = 1;

        personstocks.setId(id);
        personstocks.setPerson(person);
        personstocks.setStockSymbol(stockSymbol);

        assertEquals("person matches", person, personstocks.getPerson());
        assertEquals("stock symbol matches", stockSymbol, personstocks.getStockSymbol());
        assertEquals("id matches", id, personstocks.getId());
    }

    @Test
    public void testEqualsNegativeDifferentPerson(){
        Person_Stocks person_stocks = createPersonStocksInstance();
        person_stocks.setId(1);
        String stockSymbol = "APPL";
        Person person = new Person();

        person.setFirst_name(PersonTest.first_name);
        person.setLast_name(PersonTest.last_name);
        Person_Stocks person_stocks2 = new Person_Stocks(person, stockSymbol);
        assertFalse("Different person", person_stocks.equals(person_stocks2));
    }

    @Test
    public void testEquals(){
        Person_Stocks person_stocks = createPersonStocksInstance();
        assertTrue("Same objects are equal", person_stocks.equals(createPersonStocksInstance()));
    }

    @Test
    public void testToString(){
        Person_Stocks person_stocks = createPersonStocksInstance();
        assertTrue("toString has lastName", person_stocks.toString().contains(PersonTest.last_name));
        assertTrue("toString has first name", person_stocks.toString().contains(PersonTest.first_name));
        assertTrue("toString has stock symbol", person_stocks.toString().contains("APPL"));
    }
}
