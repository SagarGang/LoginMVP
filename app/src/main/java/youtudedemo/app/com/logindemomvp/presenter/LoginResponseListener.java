package youtudedemo.app.com.logindemomvp.presenter;

import java.util.ArrayList;

import youtudedemo.app.com.logindemomvp.model.LoginListResponse;



public interface LoginResponseListener {

    void onFailure(String error);
    void onSuccess(String successmess);
    void onSuccessLogin(ArrayList<LoginListResponse> loginListResponse);
}
