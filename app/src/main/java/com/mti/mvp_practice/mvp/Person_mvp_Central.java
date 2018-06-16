/*
 * Created by Tareq Islam on 6/8/18 1:22 AM
 *
 *  Last modified 6/8/18 1:22 AM
 */

package com.mti.mvp_practice.mvp;

/***
 * Created by Tareq on 08,June,2018.
 */
public class Person_mvp_Central {

   public interface Person_View{

        void showResult(String message);

        void showError(String error);
    }


   public interface Person_Presentor{

        void saveName(String firstName, String lastName);
        void loadMessage();
    }

}
