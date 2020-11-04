package com.uml.cabral.services;

import com.uml.cabral.model.database.StockSymbolDAO;
import com.uml.cabral.model.database.PersonDAO;
import com.uml.cabral.model.database.PersonStockDAO;
import com.uml.cabral.util.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DatabasePersonService implements PersonService {

    /**
     * Get a list of all People
     *
     * @return a list of person instances
     * @throws PersonServiceException
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<PersonDAO> getperson() throws PersonServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<PersonDAO> returnPersonDAOS = null;
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(PersonDAO.class);

            returnPersonDAOS = criteria.list();
        }catch (HibernateException e){
            if (transaction != null && transaction.isActive()){
                transaction.rollback(); //close transaction if Hibernate exception is thrown.
            }
            throw new PersonServiceException("Could not get PersonDAO data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()){
                transaction.commit(); // closes transaction through rollback when done and successful.
            }
        }
        return returnPersonDAOS;
    }

    /**
     * Add a new personDAO or update an existing PersonDAO's data.
     *
     * @param personDAO a personDAO object to either update or create
     * @throws PersonServiceException if a service can not read or write to the requested data
     *                                or otherwise perform the requested operation.
     */
    @Override
    public void addOrUpdatePerson(PersonDAO personDAO) {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(personDAO);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  //close transaction if Hibernate exception is thrown.
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();   // closes transaction through rollback when done and successful.
            }
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<StockSymbolDAO> getStockSymbols(PersonDAO personDAO){
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<StockSymbolDAO> stockSymbols = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(PersonStockDAO.class);
            criteria.add(Restrictions.eq("personDAO", personDAO));

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */

            List<PersonStockDAO> list = criteria.list();
            for (PersonStockDAO personStocks : list) {
                stockSymbols.add(personStocks.getStock_symbolDAO());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
        return stockSymbols;
    }

    @Override
    public void addStockSymbolToPerson(StockSymbolDAO stockSymbol, PersonDAO personDAO) throws PersonServiceException, UnknownPersonException, UnknownStockSymbolException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersonStockDAO personStocks = new PersonStockDAO();
            personStocks.setStock_symbolDAO(stockSymbol);
            personStocks.setPersonDAO(personDAO);
            session.saveOrUpdate(personStocks);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();  // close transaction when done
            }
        }
    }
}
