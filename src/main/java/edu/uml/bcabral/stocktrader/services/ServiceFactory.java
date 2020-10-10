package edu.uml.bcabral.stocktrader.services;



/**
 * Brandon Cabral - Java 3030 StockTrader - 09/20/2020
 *
 * Factory Class for StockService. Returns a StockServiceImplementation.
 *
 */


public class ServiceFactory {

    private ServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getStockServiceInstance() {
        return new DatabaseStockService();
    }

    public static PersonService getPersonServiceInstance(){
        return new DatabasePersonService();
    }
}
