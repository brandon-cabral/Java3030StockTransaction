package edu.uml.bcabral.stockTraderTests.model;

import edu.uml.bcabral.stocktrader.model.database.StockSymbolDAO;
import edu.uml.bcabral.stocktrader.model.database.PersonDAO;
import edu.uml.bcabral.stocktrader.model.database.PersonStockDAO;
import org.junit.Test;

import static org.junit.Assert.*;

public class Person_DAO_StocksTest {

    /**
     * Create a PersonStockDAO instance for test data
     */
    public static PersonStockDAO createPersonStocksInstance(){
        PersonDAO personDAO = PersonDAOTest.createPerson();
        StockSymbolDAO stock_symbolDAO = Stock_SymbolDAOTest.createStockSymbol();
        return new PersonStockDAO(personDAO, stock_symbolDAO);
    }

    @Test
    public void testGettersAndSetters(){
        PersonDAO personDAO = PersonDAOTest.createPerson();
        StockSymbolDAO stock_symbolDAO = Stock_SymbolDAOTest.createStockSymbol();
        PersonStockDAO personstocks = new PersonStockDAO();
        int id = 1;

        personstocks.setId(id);
        personstocks.setPersonDAO(personDAO);
        personstocks.setStock_symbolDAO(stock_symbolDAO);

        assertEquals("personDAO matches", personDAO, personstocks.getPersonDAO());
        assertEquals("stock symbol matches", stock_symbolDAO, personstocks.getStock_symbolDAO());
        assertEquals("id matches", id, personstocks.getId());
    }

    @Test
    public void testEqualsNegativeDifferentPerson(){
        PersonStockDAO person_stockDAO = createPersonStocksInstance();
        person_stockDAO.setId(1);
        StockSymbolDAO stock_symbolDAO = new StockSymbolDAO();
        PersonDAO personDAO = new PersonDAO();

        personDAO.setUser_name(PersonDAOTest.user_name);
        PersonStockDAO person_stockDAO2 = new PersonStockDAO(personDAO, stock_symbolDAO);
        assertFalse("Different personDAO", person_stockDAO.equals(person_stockDAO2));
    }

    @Test
    public void testEquals(){
        PersonStockDAO person_stockDAO = createPersonStocksInstance();
        assertTrue("Same objects are equal", person_stockDAO.equals(createPersonStocksInstance()));
    }

    @Test
    public void testToString(){
        PersonStockDAO person_stockDAO = createPersonStocksInstance();
        assertTrue("toString has user_name", person_stockDAO.toString().contains(PersonDAOTest.user_name));
        assertTrue("toString has stock symbol", person_stockDAO.toString().contains(Stock_SymbolDAOTest.symbol));
    }
}
