package youtudedemo.app.com.logindemomvp.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import youtudedemo.app.com.logindemomvp.R;
import youtudedemo.app.com.logindemomvp.model.LoginListResponse;

public class ShowModelAdapter extends RecyclerView.Adapter<ShowModelAdapter.ViewHolder> {

    private static final String TAG = ShowModelAdapter.class.getSimpleName();
    private final OnItemClickedListener listener;
    private Context context;
    private ArrayList<LoginListResponse> loginListResponseArrayList;

    public ShowModelAdapter(Context context, ArrayList<LoginListResponse> loginListResponseArrayList, OnItemClickedListener listener) {
        this.context = context;
        this.loginListResponseArrayList = loginListResponseArrayList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.login_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final LoginListResponse loginListResponse = loginListResponseArrayList.get(position);
        holder.mTvId.setText(loginListResponse.getId());
        holder.mTvName.setText(loginListResponse.getName());
        holder.mTvSubject.setText(loginListResponse.getSubject());
        holder.mTvNumber.setText(loginListResponse.getPhone_number());

    }

    @Override
    public int getItemCount() {
        return (null != loginListResponseArrayList ? loginListResponseArrayList.size() : 0);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTvId;
        protected TextView mTvName;
        protected TextView mTvNumber;
        protected TextView mTvSubject;


        public ViewHolder(View itemView) {
            super(itemView);
            this.mTvId = itemView.findViewById(R.id.tv_id);
            this.mTvName =  itemView.findViewById(R.id.tv_name);
            this.mTvNumber=itemView.findViewById(R.id.tv_number);
            this.mTvSubject=itemView.findViewById(R.id.tv_subj);

        }
    }

    public interface OnItemClickedListener {
        void onItemClicked(int position, String category);
    }
}
