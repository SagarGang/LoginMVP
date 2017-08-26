package youtudedemo.app.com.logindemomvp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import youtudedemo.app.com.logindemomvp.R;
import youtudedemo.app.com.logindemomvp.Util.Constant;
import youtudedemo.app.com.logindemomvp.Util.PrefsManager;
import youtudedemo.app.com.logindemomvp.model.LoginListResponse;
import youtudedemo.app.com.logindemomvp.presenter.LoginListViews;
import youtudedemo.app.com.logindemomvp.presenter.LoginPresenter;

public class LoginMainActivity extends AppCompatActivity implements LoginListViews {

    LoginPresenter loginPresenter;
    EditText mEdtUserName;
    EditText mEdtPassword;
    Button mBtnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        PrefsManager.setPref(Constant.BASE_URL,"sagar");
        PrefsManager.setPref(Constant.LIST,"pass");


        loginPresenter=new LoginPresenter(this,this);

        initViews();

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validatefileds())
                {
                    loginPresenter.getLogin(mEdtUserName.getText().toString(),mEdtPassword.getText().toString());
                }
            }
        });

    }

    private boolean validatefileds() {

        if(mEdtUserName.getText().toString().trim().isEmpty())
        {
            mEdtUserName.setError("Please enter Username");
            mEdtUserName.requestFocus();
            return false;
        }

        if (!mEdtUserName.getText().toString().trim().equals(PrefsManager.getStringPref(Constant.BASE_URL)))
        {
            mEdtUserName.setError("Invalid Username");
            mEdtUserName.requestFocus();
            return false;
        }

        if (!mEdtPassword.getText().toString().trim().equals(PrefsManager.getStringPref(Constant.LIST)))
        {
            mEdtPassword.setError("Invalid Password");
            mEdtPassword.requestFocus();
            return false;
        }

        if (mEdtPassword.getText().toString().trim().isEmpty())
        {
            mEdtPassword.setError("Please enter Password");
            mEdtPassword.requestFocus();
            return false;
        }

        return true;
    }

    private void initViews() {
        mEdtUserName= (EditText) findViewById(R.id.edt_username);
        mEdtPassword= (EditText) findViewById(R.id.edt_password);
        mBtnSubmit= (Button) findViewById(R.id.btn_submit);
    }

    @Override
    public void onSuccess(String successMsg) {

    }

    @Override
    public void onFailure(String errorMsg) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void onSuccessCategoryList(ArrayList<LoginListResponse> loginListResponseList) {
        Intent intent=new Intent(LoginMainActivity.this,ShowListActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelableArrayList(Constant.LIST,loginListResponseList);
        intent.putExtra(Constant.LIST,bundle);
        startActivity(intent);

    }
}
