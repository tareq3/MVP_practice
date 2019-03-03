/*
 * Created by Tareq Islam on 3/3/19 8:54 PM
 *
 *  Last modified 3/3/19 8:47 PM
 */

/*
 * Created by Tareq Islam on 6/8/18 2:13 AM
 *
 *  Last modified 6/8/18 2:13 AM
 */

package com.mti.mvp_practice.di.module;

import com.mti.mvp_practice.domain.model.PersonModel;
import com.mti.mvp_practice.view.person.PersonView;

import dagger.Module;
import dagger.Provides;

/***
 * Created by Tareq on 08,June,2018.
 */

/*Getting ready Model and Presenter Interface for injecting */
/*Module is the place the true */

@Module
public class PersonModule {

    /*Interface of the View*/
    private final PersonView mPerson_view;

    /*Interface of the presenter*/
    private final PersonModel mPerson_model;

    /*Constructor*/
    public PersonModule(PersonView person_view, PersonModel person_model) {
        mPerson_view = person_view;
        mPerson_model = person_model;
    }


    /*provide really provide or prepare the injection in the back*/
    @Provides
    PersonModel provide_person_Model(){
        return mPerson_model;
    }

    @Provides
    PersonView  provide_person_View(){
        return mPerson_view;
    }

    //here we are providing a sample provide with some two used attribute
   /* @Provides
    @Singleton
    @Named("BaseUrl")
    Retrofit provideBaseRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(URLConstants.API_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
*/
}
