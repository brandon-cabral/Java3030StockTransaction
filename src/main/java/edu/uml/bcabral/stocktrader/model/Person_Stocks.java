package edu.uml.bcabral.stocktrader.model;

import javax.persistence.*;

public class Person_Stocks {

    private int id;
    private Person person;
    private Stock_Symbol stock_symbol;


    /**
     * Creates a Person_Stocks that must be initialized for Hibernate.
     */
    public Person_Stocks(){}

    /**
     * Create a valid Person_Stocks
     *
     * @param person
     * @param stock_symbol
     */
    public Person_Stocks(Person person, Stock_Symbol stock_symbol){
        setStock_symbol(stock_symbol);
        setPerson(person);
    }

    /**
     * Primary Key - Unique ID for a specific row in the 'person_stocks' table
     *
     * @return an int (unique)
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId(){
        return id;
    }

    /**
     * Set the unique ID for a specific row in the 'person_stocks' table
     *
     * @param id is a unique value
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * get a Person following this stock symbol
     * @return Person
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "ID", nullable = false)
    public Person getPerson(){
        return person;
    }

    /**
     * Set the specific Person associated with the stock
     *
     * @param person
     */
    public void setPerson(Person person){
        this.person = person;
    }

    /**
     *Get the Stock Symbol for a specific person
     * @return String stock_symbol
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 4)
    public Stock_Symbol getStock_symbol(){
        return stock_symbol;
    }

    /**
     * Specify the stock being watched.
     * @param stocksymbol the stock symbol 4 characters long
     */
    public void setStock_symbol(Stock_Symbol stocksymbol){
        this.stock_symbol = stocksymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person_Stocks that = (Person_Stocks) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person.hashCode();
        result = 31 * result + stock_symbol.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person_Stocks{" +
                "id=" + id +
                ", person=" + person +
                ", stocksymbol=" + stock_symbol +
                '}';
    }




}
