package youtudedemo.app.com.logindemomvp.network;


import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import youtudedemo.app.com.logindemomvp.model.LoginListResponse;
import youtudedemo.app.com.logindemomvp.presenter.LoginResponseListener;

import static android.content.ContentValues.TAG;

public class LoginApiCall {

    public void getLogin(final Context mContext, String user, String password, final LoginResponseListener
            responseReceived) {

        final LoginNetwork apiService = ApiClient.getClient().create(LoginNetwork.class);

        Call<ArrayList<LoginListResponse>> call = apiService.getLoginResponse();

        call.enqueue(new Callback<ArrayList<LoginListResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<LoginListResponse>> call, Response<ArrayList<LoginListResponse>> response) {
                Log.v(TAG,response.toString());
                responseReceived.onSuccessLogin(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<LoginListResponse>> call, Throwable t) {
                if (t instanceof Exception)
                {
                    responseReceived.onFailure(t.toString());
                }

            }
        });
    }

}
