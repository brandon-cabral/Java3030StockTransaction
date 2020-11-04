package com.uml.cabral.services;

import com.uml.cabral.model.database.StockSymbolDAO;
import com.uml.cabral.model.database.PersonDAO;

import java.util.List;

public interface PersonService {
    /**
     * Get a list of all people
     *
     * @return a list of PersonDAO Instances
     * @throws PersonServiceException if a service can not read or write the requested data or otherwise perform the requested operation.
     */
    List<PersonDAO> getperson() throws PersonServiceException;

    /**
     * Add a new personDAO or update an existing PersonDAO's data.
     *
     * @param personDAO a personDAO object to either update or create
     * @throws PersonServiceException if a service can not read or write to the requested data
     *                                or otherwise perform the requested operation.
     */

    void addOrUpdatePerson(PersonDAO personDAO) throws PersonServiceException, DuplicateUserNameException;

    /**
     * get a list of all the stocks a personDAO is following.
     *
     * @return a list of stock symbols
     * @throws PersonServiceException if a service can not read or write to the requested data
     *                                or otherwise perform the requested operation.
     */
    List<StockSymbolDAO> getStockSymbols(PersonDAO personDAO) throws PersonServiceException;


    /**
     * Add a new stockSymbol to follow or update an existing PersonDAO's data.
     *
     * @param stockSymbol a string of the stockSymbol
     * @param personDAO a personDAO object to either update or create
     * @throws PersonServiceException if a service can not read or write to the requested data
     *                                or otherwise perform the requested operation.
     */
    void addStockSymbolToPerson(StockSymbolDAO stockSymbol, PersonDAO personDAO) throws PersonServiceException, UnknownStockSymbolException, UnknownPersonException;
}
