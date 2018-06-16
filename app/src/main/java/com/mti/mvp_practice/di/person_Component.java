/*
 * Created by Tareq Islam on 6/8/18 2:20 AM
 *
 *  Last modified 6/8/18 2:20 AM
 */

package com.mti.mvp_practice.di;

import com.mti.mvp_practice.MainActivity;

import dagger.Component;

/***
 * Created by Tareq on 08,June,2018.
 */
@Component(modules = Person_presenter_Module.class)
public interface person_Component {

    void inject(MainActivity mainActivity);



}
