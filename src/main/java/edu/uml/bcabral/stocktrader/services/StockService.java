package edu.uml.bcabral.stocktrader.services;

import edu.uml.bcabral.stocktrader.model.StockQuote;
import edu.uml.bcabral.stocktrader.util.Interval;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Interface for the StockService. Inludes methods for getQuote. One returns an
 * instantiation of StockTransaction, the other returns a list of StockTransactions.
 *
 */

import java.util.Calendar;
import java.util.List;

/**
 * This interface describes a simple stock purchase service.
 */
public interface StockService {

        /**
         * Return the current price for a share of stock  for the given symbol
         *
         * @param symbol the stock symbol of the company you want a quote for.
         *               e.g. APPL for APPLE
         * @return a  <CODE>BigDecimal</CODE> instance
         * @throws StockServiceException if using the service generates an exception.
         *                               If this happens, trying the service may work, depending on the actual cause of the
         *                               error.
         */
        StockQuote getQuote(String symbol) throws StockServiceException;

        /**
         * Get a historical list of stock quotes for the provide symbol
         *
         * @param symbol the stock symbol to search for
         * @param from   the date of the first stock quote
         * @param until  the date of the last stock quote
         * @return a list of StockQuote instances
         * @throws StockServiceException if using the service generates an exception.
         *                               If this happens, trying the service may work, depending on the actual cause of the
         *                               error.
         */

        List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) throws StockServiceException;

        void addOrUpdateStockQuotes(List<String> stock) throws StockServiceException;

        /**
         * Get a list of all StockQuotes
         *
         * @return a list of stockquote instances
         * @throws StockServiceException
         */

        public List<StockQuote> getStockQuotes() throws StockServiceException;
}