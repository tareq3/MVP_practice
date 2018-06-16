/*
 * Created by Tareq Islam on 6/8/18 1:19 AM
 *
 *  Last modified 6/8/18 1:19 AM
 */

package com.mti.mvp_practice.mvp;

/***
 * Created by Tareq on 08,June,2018.
 */
public class person_Model {

   private String firstName;
   private String LastName;

    public person_Model() {
    }

    public person_Model(String firstName, String lastName) {
        this.firstName = firstName;
        LastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName(){
        return firstName + LastName;
    }
}
