package youtudedemo.app.com.logindemomvp.presenter;


import android.content.Context;

import java.util.ArrayList;

import youtudedemo.app.com.logindemomvp.model.LoginListResponse;
import youtudedemo.app.com.logindemomvp.network.LoginApiCall;

public class LoginPresenter implements LoginResponseListener{
    Context mContext;
    LoginListViews loginListView;

    public LoginPresenter(Context context, LoginListViews loginListViews) {
        mContext = context;
        loginListView = loginListViews;
    }


    @Override
    public void onFailure(String error) {
        loginListView.hideProgressBar();
        loginListView.onFailure(error);

    }

    @Override
    public void onSuccess(String successmess) {

    }

    @Override
    public void onSuccessLogin(ArrayList<LoginListResponse> loginListResponse) {
        loginListView.hideProgressBar();
        loginListView.onSuccessCategoryList(loginListResponse);

    }

   public void getLogin(String username,String pass)
   {
       new LoginApiCall().getLogin(mContext,username,pass,LoginPresenter.this);
   }
}
