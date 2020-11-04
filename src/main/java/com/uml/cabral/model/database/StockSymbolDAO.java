package com.uml.cabral.model.database;

import javax.persistence.*;

@Entity
@Table(name="stock_symbol")
public class StockSymbolDAO {

    private int id;
    private String stock_symbol;

    /**
     * Primary Key ID, links to a specific person in the person table.
     * @return an int value
     */

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id = id;
    }

    /**
     * Gets the symbol for a stock.
     * @return the stocks 4 char name
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 4)
    public String getStock_symbol(){
        return stock_symbol;
    }

    public void setStock_symbol(String symbol){
        this.stock_symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockSymbolDAO stocksymbol = (StockSymbolDAO) o;

        if (id != stocksymbol.id) return false;
        if (stock_symbol != null ? !stock_symbol.equals(stocksymbol.stock_symbol) : stocksymbol.stock_symbol != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (stock_symbol != null ? stock_symbol.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stock Symbol{" +
                "id=" + id +
                ", stockSymbol='" + stock_symbol + '\\' +
                '}';
    }



}
