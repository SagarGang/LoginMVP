package youtudedemo.app.com.logindemomvp.network;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.POST;
import youtudedemo.app.com.logindemomvp.model.LoginListResponse;

public interface LoginNetwork {
    @POST("jsonData.php")
    Call<ArrayList<LoginListResponse>> getLoginResponse();
}
