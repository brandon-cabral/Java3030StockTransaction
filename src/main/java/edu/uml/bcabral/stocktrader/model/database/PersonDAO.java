package edu.uml.bcabral.stocktrader.model.database;

import javax.persistence.*;

/**
 * Models the 'person' table in the 'stocks' database
 *
 */

@Entity
@Table(name="person", schema = "", catalog = "stocks")
public class PersonDAO {

    private int id;
    private String user_name;

    /**
     * Primary Key ID, links to a specific person in the person table.
     * @return an int value
     */

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getID(){
        return id;
    }

    /**
     * Sets the unique ID for a person in the 'person' table.
     * @param id (unique value)
     */
    public void setID(int id){
        this.id = id;
    }

    /**
     * Gets the user_name for a person.
     * @return the person's first name
     */
    @Basic
    @Column(name = "user_name", nullable = false, insertable = true, updatable = true, length = 256)
    public String getUser_name(){
        return user_name;
    }

    /**
     *Sets the first_name for a person from the person table
     * @param name String value for user_name
     */
    public void setUser_name(String name){
        this.user_name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDAO personDAO = (PersonDAO) o;

        if (id != personDAO.id) return false;
        if (user_name != null ? !user_name.equals(personDAO.user_name) : personDAO.user_name != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (user_name != null ? user_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonDAO{" +
                "id=" + id +
                ", firstName='" + user_name + '\\' +
                '}';
    }

}
