package edu.uml.bcabral.stocktrader.services;

import edu.uml.bcabral.stocktrader.model.StockQuote;
import edu.uml.bcabral.stocktrader.model.StockSymbolType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Factory Class for StockService. Returns a StockServiceImplementation.
 *
 */


public class StockServiceFactory{

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getInstance() {
        return new DatabaseStockService();
    }
}
