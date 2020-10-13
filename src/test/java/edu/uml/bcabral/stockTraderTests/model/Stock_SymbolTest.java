package edu.uml.bcabral.stockTraderTests.model;

import edu.uml.bcabral.stocktrader.model.Stock_Symbol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Stock_SymbolTest {

    public static final String symbol = "APPL";

    /**
     * Create a StockSymbol Instance to generate test data.
     * @return a StockSymbol Object
     */
    public static Stock_Symbol createStockSymbol() {
        Stock_Symbol stocksymbol = new Stock_Symbol();
        stocksymbol.setStock_symbol(symbol);
        return stocksymbol;
    }

    @Test
    public void testPersonGettersAndSetters(){
        Stock_Symbol stock_symbol = createStockSymbol();
        int id = 1;
        stock_symbol.setID(id);

        assertEquals("symbol matches", symbol, stock_symbol.getStock_symbol());
        assertEquals("id matches", id, stock_symbol.getID());
    }


}
