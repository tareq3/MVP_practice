/*
 * Created by Tareq Islam on 6/8/18 1:38 AM
 *
 *  Last modified 6/8/18 1:38 AM
 */

package com.mti.mvp_practice.mvp;



import javax.inject.Inject;

/***
 * Created by Tareq on 08,June,2018.
 */
public class Person_presenter_Manager implements Person_mvp_Central.Person_Presentor{

    person_Model mPerson_model;

    Person_mvp_Central.Person_View mPerson_view;


   /* public Person_presenter_Manager(Person_mvp_Central.Person_View person_view) { //as View gonna have  connection with activity
        *//*
              * As our policy is activity will never know about model
         *//*
           mPerson_model = new person_Model(); //we are making an object as model only cooperate with presenter
        mPerson_view = person_view;
    }
*/

    @Inject
    public Person_presenter_Manager(person_Model person_model, Person_mvp_Central.Person_View person_view) {
        mPerson_model = person_model;
        mPerson_view = person_view;
    }

    @Override
    public void saveName(String firstName, String lastName) {

        mPerson_model.setFirstName(firstName);
        mPerson_model.setLastName(lastName);

    }

    @Override
    public void loadMessage() {

        if(mPerson_model.getFirstName()==null && mPerson_model.getLastName()==null){
            mPerson_view.showError("No data found yet");
        }else {

            String message = "Hi " + mPerson_model.getName() + " !";

            mPerson_view.showResult(message);
        }
    }
}
