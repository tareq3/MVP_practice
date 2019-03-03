/*
 * Created by Tareq Islam on 3/3/19 9:18 PM
 *
 *  Last modified 3/3/19 9:17 PM
 */

/*
 * Created by Tareq Islam on 3/3/19 8:46 PM
 *
 *  Last modified 3/3/19 8:37 PM
 */

/*
 * Created by Tareq Islam on 6/8/18 1:27 AM
 *
 *  Last modified 6/8/18 1:13 AM
 */

package com.mti.mvp_practice.view.person;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mti.mvp_practice.R;

import javax.inject.Inject;
import com.mti.mvp_practice.di.*;
import com.mti.mvp_practice.di.component.DaggerPersonComponent;
import com.mti.mvp_practice.di.module.PersonModule;
import com.mti.mvp_practice.domain.model.PersonModel;

public class PersonActivity extends AppCompatActivity implements PersonView,View.OnClickListener {

    @Inject
    PersonPresenterImpl mPerson_presentor; //we can't call the interface

    EditText firstName, lastName;


    TextView displayView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //without dipendency injection
        /*mPerson_presentor=new PersonPresenterImpl(new PersonModel(), this);*/


        //Here DaggerPersonComponet is the dagger compile reference of PersonComponent
        //personModule is the dagger compile reference of PersonModule
        DaggerPersonComponent.builder().
               personModule(
                       new PersonModule(this,
                               new PersonModel())
               ).
               build().
               inject(this);
    }

    private void initViews() {
        firstName=findViewById(R.id.firstName);
        lastName=findViewById(R.id.lastName);
        displayView=findViewById(R.id.message);

        findViewById(R.id.showMessage).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
    }

    //this method recieving result
    @Override
    public void showResult(String message) {

        displayView.setText(message);

    }


    @Override
    public void showError(String error) {

        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showMessage:

                mPerson_presentor.loadMessage();
                break;

            case R.id.update:
                mPerson_presentor.saveName(firstName.getText().toString(),lastName.getText().toString());
                break;



        }

    }
}
