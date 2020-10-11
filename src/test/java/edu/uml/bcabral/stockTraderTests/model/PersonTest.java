package edu.uml.bcabral.stockTraderTests.model;

import edu.uml.bcabral.stocktrader.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    public static final String first_name = "Brandon";
    public  static final String last_name = "Cabral";

    /**
     * Create a Person Instance to generate test data.
     * @return a Person Object
     */
    public static Person createPerson() {
        Person person = new Person();
        person.setFirst_name(first_name);
        person.setLast_name(last_name);
        return person;
    }

    @Test
    public void testPersonGettersAndSetters(){
        Person person = createPerson();
        int id = 1;
        person.setID(id);

        assertEquals("first name matches", first_name, person.getFirst_name());
        assertEquals("last name matches", last_name, person.getLast_name());
        assertEquals("id matches", id, person.getID());
    }


}
