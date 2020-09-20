package edu.uml.bcabral.stocktrader;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Interface for the StockService. Inludes methods for getQuote. One returns an
 * instantiation of StockTransaction, the other returns a list of StockTransactions.
 *
 */

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * This interface describes a simple stock purchase service.
 */
public interface StockService {

        /**
         * Return the current price for a share of stock  for the given symbol
         * @param symbol the stock symbol of the company you want a quote for e.g. APPL for APPLE
         * @return a  <CODE>BigDecimal</CODE> instance
         */
        StockTransaction getQuote(StockSymbolType symbol, Timestamp timeOfTransaction);

        /**
         * Get a historical list of stock quotes for the provide symbol
         * @param symbol the stock symbol to search for
         * @param from the date of the first stock quote
         * @param until  the date of the last stock quote
         * @return a list of StockQuote instances. One for each day in the range specified.
         */
        List<StockTransaction> getQuote(StockSymbolType symbol, Calendar from, Calendar until);

}
