package edu.uml.bcabral.stockTraderTests.model;

import edu.uml.bcabral.stocktrader.model.Person;
import edu.uml.bcabral.stocktrader.model.Person_Stocks;
import edu.uml.bcabral.stocktrader.model.Stock_Symbol;
import org.junit.Test;

import static org.junit.Assert.*;

public class Person_StocksTest {

    /**
     * Create a Person_Stocks instance for test data
     */
    public static Person_Stocks createPersonStocksInstance(){
        Person person = PersonTest.createPerson();
        Stock_Symbol stock_symbol = Stock_SymbolTest.createStockSymbol();
        return new Person_Stocks(person,stock_symbol);
    }

    @Test
    public void testGettersAndSetters(){
        Person person = PersonTest.createPerson();
        Stock_Symbol stock_symbol = Stock_SymbolTest.createStockSymbol();
        Person_Stocks personstocks = new Person_Stocks();
        int id = 1;

        personstocks.setId(id);
        personstocks.setPerson(person);
        personstocks.setStock_symbol(stock_symbol);

        assertEquals("person matches", person, personstocks.getPerson());
        assertEquals("stock symbol matches", stock_symbol, personstocks.getStock_symbol());
        assertEquals("id matches", id, personstocks.getId());
    }

    @Test
    public void testEqualsNegativeDifferentPerson(){
        Person_Stocks person_stocks = createPersonStocksInstance();
        person_stocks.setId(1);
        Stock_Symbol stock_symbol = new Stock_Symbol();
        Person person = new Person();

        person.setUser_name(PersonTest.user_name);
        Person_Stocks person_stocks2 = new Person_Stocks(person, stock_symbol);
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
        assertTrue("toString has user_name", person_stocks.toString().contains(PersonTest.user_name));
        assertTrue("toString has stock symbol", person_stocks.toString().contains(Stock_SymbolTest.symbol));
    }
}
