package edu.uml.bcabral.stocktrader.services;

import edu.uml.bcabral.stocktrader.model.Person;
import edu.uml.bcabral.stocktrader.model.Person_Stocks;
import edu.uml.bcabral.stocktrader.model.Stock_Symbol;
import edu.uml.bcabral.stocktrader.util.DatabaseUtils;
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
    public List<Person> getperson() throws PersonServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<Person> returnPersons = null;
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person.class);

            returnPersons = criteria.list();
        }catch (HibernateException e){
            if (transaction != null && transaction.isActive()){
                transaction.rollback(); //close transaction if Hibernate exception is thrown.
            }
            throw new PersonServiceException("Could not get Person data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()){
                transaction.commit(); // closes transaction through rollback when done and successful.
            }
        }
        return returnPersons;
    }

    /**
     * Add a new person or update an existing Person's data.
     *
     * @param person a person object to either update or create
     * @throws PersonServiceException if a service can not read or write to the requested data
     *                                or otherwise perform the requested operation.
     */
    @Override
    public void addOrUpdatePerson(Person person) {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
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
    public List<Stock_Symbol> getStockSymbols(Person person){
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Stock_Symbol> stockSymbols = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person_Stocks.class);
            criteria.add(Restrictions.eq("person", person));

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */

            List<Person_Stocks> list = criteria.list();
            for (Person_Stocks personStocks : list) {
                stockSymbols.add(personStocks.getStock_symbol());
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
    public void addStockSymbolToPerson(Stock_Symbol stockSymbol, Person person) throws PersonServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Person_Stocks personStocks = new Person_Stocks();
            personStocks.setStock_symbol(stockSymbol);
            personStocks.setPerson(person);
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
