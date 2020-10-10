package edu.uml.bcabral.stocktrader.services;

import edu.uml.bcabral.stocktrader.model.Person;
import java.util.List;

public interface PersonService {
    /**
     * Get a list of all people
     *
     * @return a list of Person Instances
     * @throws PersonServiceException if a service can not read or write the requested data or otherwise perform the requested operation.
     */
    List<Person> getperson() throws PersonServiceException;

    /**
     * Add a new person or update an existing Person's data.
     *
     * @param person a person object to either update or create
     * @throws PersonServiceException if a service can not read or write to the requested data
     *                                or otherwise perform the requested operation.
     */

    void addOrUpdatePerson(Person person) throws PersonServiceException;

    /**
     * get a list of all the stocks a person is following.
     *
     * @return a list of stock symbols
     * @throws PersonServiceException if a service can not read or write to the requested data
     *                                or otherwise perform the requested operation.
     */
    List<String> getStockSymbols(Person person) throws PersonServiceException;


    /**
     * Add a new stockSymbol to follow or update an existing Person's data.
     *
     * @param stockSymbol a string of the stockSymbol
     * @param person a person object to either update or create
     * @throws PersonServiceException if a service can not read or write to the requested data
     *                                or otherwise perform the requested operation.
     */
    void addStockSymbolToPerson(String stockSymbol, Person person) throws PersonServiceException;
}
