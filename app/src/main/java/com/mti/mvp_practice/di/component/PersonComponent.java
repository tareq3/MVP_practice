/*
 * Created by Tareq Islam on 3/3/19 8:54 PM
 *
 *  Last modified 3/3/19 8:47 PM
 */

/*
 * Created by Tareq Islam on 6/8/18 2:20 AM
 *
 *  Last modified 6/8/18 2:20 AM
 */

package com.mti.mvp_practice.di.component;

import com.mti.mvp_practice.di.module.PersonModule;
import com.mti.mvp_practice.view.person.PersonActivity;

import dagger.Component;

/***
 * Created by Tareq on 08,June,2018.
 */

/*Components are like beans then does nothing but keeping reference of injections*/

@Component(modules = PersonModule.class)
public interface PersonComponent {

    //here we can create multiple abstract injection method but has to be same name
    void inject(PersonActivity mainActivity);

    /*
    void inject(GoogleRepositoryImpl googleRepository);*/



}
