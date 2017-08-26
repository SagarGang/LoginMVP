package youtudedemo.app.com.logindemomvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import youtudedemo.app.com.logindemomvp.R;
import youtudedemo.app.com.logindemomvp.Util.Constant;
import youtudedemo.app.com.logindemomvp.adapter.ShowModelAdapter;
import youtudedemo.app.com.logindemomvp.model.LoginListResponse;

public class ShowListActivity extends AppCompatActivity implements ShowModelAdapter.OnItemClickedListener{

    RecyclerView recyclerView;
    ShowModelAdapter showModelAdapter;
    ArrayList<LoginListResponse> loginListResponseArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        Bundle bundle=getIntent().getBundleExtra(Constant.LIST);
        if (bundle!=null)
        {
            loginListResponseArrayList  =bundle.getParcelableArrayList(Constant.LIST);
        }
        recyclerView= (RecyclerView) findViewById(R.id.recycle_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowListActivity.this, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        showModelAdapter = new ShowModelAdapter(ShowListActivity.this, loginListResponseArrayList, this);
        recyclerView.setAdapter(showModelAdapter);
    }

    @Override
    public void onItemClicked(int position, String category) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
