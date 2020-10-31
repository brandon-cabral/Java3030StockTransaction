package edu.uml.bcabral.stocktrader.model.database;

import javax.persistence.*;

/**
 * Models the 'personStock' table in the 'stocks' database
 *
 */

@Entity
@Table(name = "person_stocks", schema = "", catalog = "stocks")
public class PersonStockDAO {

    private int id;
    private PersonDAO personDAO;
    private StockSymbolDAO stock_symbolDAO;


    /**
     * Creates a PersonStockDAO that must be initialized for Hibernate.
     */
    public PersonStockDAO(){}

    /**
     * Create a valid PersonStockDAO
     *
     * @param personDAO
     * @param stock_symbolDAO
     */
    public PersonStockDAO(PersonDAO personDAO, StockSymbolDAO stock_symbolDAO){
        setStock_symbolDAO(stock_symbolDAO);
        setPersonDAO(personDAO);
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
     * get a PersonDAO following this stock symbol
     * @return PersonDAO
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "ID", nullable = false)
    public PersonDAO getPersonDAO(){
        return personDAO;
    }

    /**
     * Set the specific PersonDAO associated with the stock
     *
     * @param personDAO
     */
    public void setPersonDAO(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    /**
     *Get the Stock Symbol for a specific personDAO
     * @return String stock_symbolDAO
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 4)
    public StockSymbolDAO getStock_symbolDAO(){
        return stock_symbolDAO;
    }

    /**
     * Specify the stock being watched.
     * @param stocksymbol the stock symbol 4 characters long
     */
    public void setStock_symbolDAO(StockSymbolDAO stocksymbol){
        this.stock_symbolDAO = stocksymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonStockDAO that = (PersonStockDAO) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + personDAO.hashCode();
        result = 31 * result + stock_symbolDAO.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PersonStockDAO{" +
                "id=" + id +
                ", personDAO=" + personDAO +
                ", stocksymbol=" + stock_symbolDAO +
                '}';
    }




}
