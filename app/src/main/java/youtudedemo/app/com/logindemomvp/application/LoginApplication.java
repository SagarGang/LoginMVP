package youtudedemo.app.com.logindemomvp.application;

import android.app.Application;


public class LoginApplication extends Application {
    private static LoginApplication loginApplication;



    public static LoginApplication getInstance() {
        return loginApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        loginApplication = this;


    }

}
