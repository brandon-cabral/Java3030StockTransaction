package edu.uml.bcabral.stocktrader;

/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Factory Class for StockService. Returns a StockServiceImplementation.
 *
 */


public class StockServiceFactory{

    /**
     * StockService method createStockService that returns a new StockServiceImplementation
     */
    public static StockService createStockService(){
        return new StockServiceImplementation();
    }
}
