/*
 * Created by Tareq Islam on 6/8/18 2:13 AM
 *
 *  Last modified 6/8/18 2:13 AM
 */

package com.mti.mvp_practice.di;

import com.mti.mvp_practice.mvp.Person_mvp_Central;
import com.mti.mvp_practice.mvp.Person_mvp_Central.*;
import com.mti.mvp_practice.mvp.person_Model;

import dagger.Module;
import dagger.Provides;

/***
 * Created by Tareq on 08,June,2018.
 */

@Module
public class Person_presenter_Module {

    private final Person_View mPerson_view;

    private final person_Model mPerson_model;

    public Person_presenter_Module(Person_View person_view, person_Model person_model) {
        mPerson_view = person_view;
        mPerson_model = person_model;
    }

    @Provides
    person_Model provide_person_Model(){
        return mPerson_model;
    }

    @Provides
    Person_View  provide_person_View(){
        return mPerson_view;
    }

}
