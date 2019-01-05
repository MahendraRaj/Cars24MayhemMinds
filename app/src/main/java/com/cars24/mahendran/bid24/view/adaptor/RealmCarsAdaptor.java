/*
 * Copyright (c) 2016 - 2017 1Banyan Inc. - All rights reserved.
 * Unauthorized copying of this file is strictly prohibited
 * Proprietary and confidential
 */

package com.cars24.mahendran.bid24.view.adaptor;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cars24.mahendran.bid24.R;
import com.cars24.mahendran.bid24.model.CarObject;
import com.cars24.mahendran.bid24.view.util.GlideApp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmViewHolder;

/**
 * Created by mahendra on 01-07-2016.
 */
public class RealmCarsAdaptor extends RealmRecyclerViewAdapter<CarObject, RealmCarsAdaptor.MyHolder> implements View.OnLongClickListener {

    private OrderedRealmCollection<CarObject> objects;
    private Activity activity;
    private int radius;

    public RealmCarsAdaptor(Activity activity, OrderedRealmCollection<CarObject> realmResults, boolean automaticUpdate, boolean animateResults) {
        super(realmResults, automaticUpdate);

//        radius = AndroidUtilities.dp(2);
        this.objects = realmResults;
        this.activity = activity;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View child = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item_car, viewGroup, false);

        return new MyHolder(child);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        CarObject carObject = objects.get(position);
        holder.bind(carObject);

        holder.tvCarName.setText(carObject.getName());

        GlideApp.with(holder.itemView)
                .load(carObject.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fitCenter()
                .into(holder.ivCar);

        GlideApp.with(holder.itemView)
                .load(new ColorDrawable(Color.parseColor("#00ff00")))
                .circleCrop()
                .into(holder.ivLive);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:MM a",Locale.getDefault());
        holder.tvBiddingLive.setText("Ends at\n" + simpleDateFormat.format(Calendar.getInstance().getTime()));
    }


    @Override
    public int getItemCount() {
        return this.objects.size();
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }


    class MyHolder extends RealmViewHolder {
        private TextView tvCarName;
        private TextView tvMinBidPrice;
        private TextView tvBiddingLive;
        private ImageView ivCar;
        private ImageView ivLive;
        private CarObject carObject;

        public void bind(CarObject group) {
            carObject = group;
        }
        MyHolder(View itemView) {
            super(itemView);
            tvCarName = itemView.findViewById(R.id.carName);
            tvMinBidPrice = itemView.findViewById(R.id.tvMinBidPrice);
            tvBiddingLive = itemView.findViewById(R.id.tvBiddingLive);
            ivCar = itemView.findViewById(R.id.ivCar);
            ivLive = itemView.findViewById(R.id.ivLive);



        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
