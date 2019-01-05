package com.cars24.mahendran.bid24.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CarObject extends RealmObject {
    @PrimaryKey
    private String id;

    private String name;

    private String model;
    private long price;
    private String imageUrl;
    private Date bidStartTime;
    private long minBiddingPrice;


}
