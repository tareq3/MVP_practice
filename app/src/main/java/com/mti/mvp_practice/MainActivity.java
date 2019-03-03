/*
 * Created by Tareq Islam on 6/8/18 1:27 AM
 *
 *  Last modified 6/8/18 1:13 AM
 */

package com.mti.mvp_practice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mti.mvp_practice.mvp.Person_mvp_Central;
import com.mti.mvp_practice.mvp.Person_presenter_Manager;

import javax.inject.Inject;
import com.mti.mvp_practice.di.*;
import com.mti.mvp_practice.mvp.person_Model;

public class MainActivity extends AppCompatActivity implements Person_mvp_Central.Person_View,View.OnClickListener {

    @Inject
    Person_presenter_Manager mPerson_presentor; //we can't call the interface

    EditText firstName, lastName;


    TextView displayView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

       /* mPerson_presentor=new Person_presenter_Manager(this);*/

       Daggerperson_Component.builder().
               person_presenter_Module(
                       new Person_presenter_Module(this,
                               new person_Model())
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
