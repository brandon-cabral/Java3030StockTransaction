package edu.uml.bcabral.stockTraderTests.model;

import edu.uml.bcabral.stocktrader.model.database.StockSymbolDAO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Stock_SymbolDAOTest {

    public static final String symbol = "APPL";

    /**
     * Create a StockSymbol Instance to generate test data.
     * @return a StockSymbol Object
     */
    public static StockSymbolDAO createStockSymbol() {
        StockSymbolDAO stocksymbol = new StockSymbolDAO();
        stocksymbol.setStock_symbol(symbol);
        return stocksymbol;
    }

    @Test
    public void testPersonGettersAndSetters(){
        StockSymbolDAO stock_symbolDAO = createStockSymbol();
        int id = 1;
        stock_symbolDAO.setID(id);

        assertEquals("symbol matches", symbol, stock_symbolDAO.getStock_symbol());
        assertEquals("id matches", id, stock_symbolDAO.getID());
    }


}
