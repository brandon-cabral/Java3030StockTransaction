package edu.uml.bcabral.stocktrader;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Class StockTraderApp that runs the client code.
 *
 */


import java.sql.Timestamp;
import java.util.Calendar;

public class StockTraderApp {

    public static void main(String[] args) {
        StockService stockService = StockServiceFactory.createStockService();
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        StockTransaction stockTransaction = stockService.getQuote(StockSymbolType.AMZ, timestamp); //new stocktransaction
        System.out.println(stockTransaction.getTime());         //verify time
        System.out.println(stockTransaction.getStockSymbol());  //verify symbol
        System.out.println(stockTransaction.getPrice());        // verify price
        System.out.println(stockTransaction.toString());        //verify to string

    }
}
