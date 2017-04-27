package com.kurta.example.admin.kruta.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.kurta.R;
import com.kurta.example.admin.kruta.Model.DashboardItem;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Krutarth on 4/25/2017.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder>{

    public List<DashboardItem> DashboardItem;

    String TAG = "AllNewsAdapter ::";
    Context ctx;

    public DashboardAdapter(Context ctx,List<DashboardItem> feedItems) {
        this.DashboardItem = feedItems;
        this.ctx = ctx;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFname, notification, tvLname;
        TextView email;
        ImageView thumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvFname = (TextView) itemView.findViewById(R.id.fName);
            this.tvLname = (TextView) itemView.findViewById(R.id.lName);

            this.thumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);
            this.email = (TextView) itemView.findViewById(R.id.email);
            this.notification = (TextView) itemView.findViewById(R.id.notification);

            this.tvFname.setTextColor(Color.WHITE);
            this.tvLname.setTextColor(Color.WHITE);
            this.notification.setTextColor(Color.WHITE);
            this.email.setTextColor(Color.WHITE);
        }
    }

    @Override
    public DashboardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_listview, parent, false);
        DashboardAdapter.ViewHolder viewHolder = new DashboardAdapter.ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(DashboardAdapter.ViewHolder holder, int position) {
        holder.email.setText(DashboardItem.get(position).getRecords().get(position).getEmail());
        holder.tvFname.setText(DashboardItem.get(position).getRecords().get(position).getFname());
        holder.tvLname.setText(DashboardItem.get(position).getRecords().get(position).getLname());

        Picasso.with(ctx).load(DashboardItem.get(position).getRecords().get(position).getPictureUrl().replace("\\", "").replaceAll(" ", "%20")).fit()
                .placeholder(R.drawable.profile)
                .error(R.drawable.profile).into(holder.thumbnail, new Callback() {
            @Override
            public void onSuccess() {
            }
            @Override
            public void onError() {
            }
        });

    }


    @Override
    public int getItemCount() {

        return DashboardItem.size();
    }

    public int getCount() {
        return DashboardItem.size();
    }

    public com.kurta.example.admin.kruta.Model.DashboardItem getItem(int i) {
        return DashboardItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

}
