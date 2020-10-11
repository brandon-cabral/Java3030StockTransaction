package edu.uml.bcabral.stocktrader.model;

import javax.persistence.*;

/**
 * Models the 'person' table in the 'stocks' database
 *
 */

@Entity
@Table(name="person")
public class Person {

    private int id;
    private String first_name;
    private String last_name;

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
     * Gets the first_name for a person.
     * @return the person's first name
     */
    @Basic
    @Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 256)
    public String getFirst_name(){
        return first_name;
    }

    /**
     *Sets the first_name for a person from the person table
     * @param first String value for first name
     */
    public void setFirst_name(String first){
        this.first_name = first;
    }

    /**
     * Gets the last_name for a person.
     * @return the person's last name
     */
    @Basic
    @Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 256)
    public String getLast_name(){
        return last_name;
    }

    /**
     *Sets the first_name for a person from the person table
     * @param last String value for first name
     */
    public void setLast_name(String last){
        this.last_name = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (first_name != null ? !first_name.equals(person.first_name) : person.first_name != null) {
            return false;
        }
        if (last_name != null ? !last_name.equals(person.last_name) : person.last_name != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + first_name + '\\' +
                ", lastName='" + last_name + '\\' +
                '}';
    }

}
