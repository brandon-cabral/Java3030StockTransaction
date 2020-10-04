package edu.uml.bcabral.stocktrader.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * A container class that contains stock data.
 */
public class StockQuote extends StockData {

    private BigDecimal price;
    private Date date;
    private StockSymbolType symbol;

    /**
     * Create a new instance of a StockQuote.
     *
     * @param price  the share price for the given date
     * @param date   the date of the share price
     * @param symbol the stock symbol.
     */
    public StockQuote(BigDecimal price, Date date, StockSymbolType symbol) {
        super();
        this.price = price;
        this.date = date;
        this.symbol = symbol;
    }

    /**
     * @return Get the share price for the given date.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return The date of the share price
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return The stock symbol.
     */
    public StockSymbolType getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        String dateString = simpleDateFormat.format(date);
        return "StockQuote{" +
                "price=" + price +
                ", date=" + dateString +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
