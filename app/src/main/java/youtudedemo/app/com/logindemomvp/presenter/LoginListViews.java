package youtudedemo.app.com.logindemomvp.presenter;

import java.util.ArrayList;

import youtudedemo.app.com.logindemomvp.model.LoginListResponse;

public interface LoginListViews {

    void onSuccess(String successMsg);
    void onFailure(String errorMsg);
    void showProgressBar();
    void hideProgressBar();
    void onSuccessCategoryList(ArrayList<LoginListResponse> loginListResponseList);
}
