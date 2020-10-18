package edu.uml.bcabral.stockTraderTests.model;

import edu.uml.bcabral.stocktrader.model.database.PersonDAO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonDAOTest {
    public static final String user_name = "Brandon";


    /**
     * Create a PersonDAO Instance to generate test data.
     * @return a PersonDAO Object
     */
    public static PersonDAO createPerson() {
        PersonDAO personDAO = new PersonDAO();
        personDAO.setUser_name(user_name);
        return personDAO;
    }

    @Test
    public void testPersonGettersAndSetters(){
        PersonDAO personDAO = createPerson();
        int id = 1;
        personDAO.setID(id);

        assertEquals("user_name matches", user_name, personDAO.getUser_name());
        assertEquals("id matches", id, personDAO.getID());
    }


}
