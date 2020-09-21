package edu.uml.bcabral.stocktrader;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Class StockServiceImplementation that implements the interface StockService.
 * Overrides the getQuote functions and provides the functionality.
 *
 */

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;     //imports
import java.util.Calendar;
import java.util.List;

public class StockServiceImplementation implements StockService {

    /**
     *
     * getQuote function that takes arguments and assigns them to a new StockTransaction
     * Instantiation. Takes BigDecimal, StockTypeSymbol, and Timestamp.
     */

    @Override
    public StockTransaction getQuote(StockSymbolType symbol, Timestamp timeOfTransaction) {
        return new StockTransaction(new BigDecimal(100),StockSymbolType.APPL,timeOfTransaction);
    }

    /**
     *
     * getQuote function that takes arguments and assigns them to a list of StockTransaction
     * Instantiations. Takes BigDecimal, StockTypeSymbol, and Timestamp.
     */

    @Override
    public List<StockTransaction> getQuote(StockSymbolType symbol, Calendar from, Calendar until) {
        List<StockTransaction> stockTransactions = new ArrayList();
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        stockTransactions.add(new StockTransaction(new BigDecimal(100),StockSymbolType.APPL,timestamp));
        return stockTransactions;
    }
}
