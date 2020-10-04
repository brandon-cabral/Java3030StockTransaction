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
        return new DatabaseStockService() {
        @Override
        public StockQuote getQuote(StockSymbolType symbol) throws StockServiceException {
            return new StockQuote(new BigDecimal(100), Calendar.getInstance().getTime(), symbol);
        }

        @Override
        public List<StockQuote> getQuote(StockSymbolType symbol, Calendar from, Calendar until) throws StockServiceException {
            List<StockQuote> stockQuotes = new ArrayList<>();
            Date aDay = from.getTime();
            while (until.after(aDay))  {
                stockQuotes.add(new StockQuote(new BigDecimal(100),aDay,symbol));
                from.add(Calendar.DAY_OF_YEAR, 1);
                aDay = from.getTime();
            }
            return stockQuotes;            }
    };
    }
}
