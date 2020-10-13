package edu.uml.bcabral.stockTraderTests.model;

import edu.uml.bcabral.stocktrader.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    public static final String user_name = "Brandon";


    /**
     * Create a Person Instance to generate test data.
     * @return a Person Object
     */
    public static Person createPerson() {
        Person person = new Person();
        person.setUser_name(user_name);
        return person;
    }

    @Test
    public void testPersonGettersAndSetters(){
        Person person = createPerson();
        int id = 1;
        person.setID(id);

        assertEquals("user_name matches", user_name, person.getUser_name());
        assertEquals("id matches", id, person.getID());
    }


}
