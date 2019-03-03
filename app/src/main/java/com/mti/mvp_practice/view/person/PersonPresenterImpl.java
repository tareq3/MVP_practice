/*
 * Created by Tareq Islam on 3/3/19 9:18 PM
 *
 *  Last modified 3/3/19 9:17 PM
 */

/*
 * Created by Tareq Islam on 6/8/18 1:38 AM
 *
 *  Last modified 6/8/18 1:38 AM
 */

package com.mti.mvp_practice.view.person;



import com.mti.mvp_practice.domain.model.PersonModel;

import javax.inject.Inject;

/***
 * Created by Tareq on 08,June,2018.
 */
public class
PersonPresenterImpl implements IPersonPresenter {

    PersonModel mPerson_model;

    PersonView mPerson_view;


   /* public PersonPresenterImpl(Person_mvp_Central.Person_View person_view) { //as View gonna have  connection with activity
        *//*
              * As our policy is activity will never know about model
         *//*
           mPerson_model = new PersonModel(); //we are making an object as model only cooperate with presenter
        mPerson_view = person_view;
    }
*/

    @Inject
    public PersonPresenterImpl(PersonModel person_model, PersonView person_view) {
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
