package edu.uml.bcabral.stocktrader;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Class StockTraderApp that runs the client code.
 *
 */

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class StockTraderApp {

    public static void main(String[] args) {
        StockService ss = StockServiceFactory.createStockService();
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction st = ss.getQuote(StockSymbolType.AMZ, timestamp);
        st.getTime();
        st.getStockSymbol();
        st.getPrice();
        st.toString();

    }
}
