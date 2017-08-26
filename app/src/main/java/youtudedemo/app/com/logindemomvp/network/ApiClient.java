package youtudedemo.app.com.logindemomvp.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import youtudedemo.app.com.logindemomvp.Util.Constant;

public class ApiClient {
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
