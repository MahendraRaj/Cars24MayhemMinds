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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getBidStartTime() {
        return bidStartTime;
    }

    public void setBidStartTime(Date bidStartTime) {
        this.bidStartTime = bidStartTime;
    }

    public long getMinBiddingPrice() {
        return minBiddingPrice;
    }

    public void setMinBiddingPrice(long minBiddingPrice) {
        this.minBiddingPrice = minBiddingPrice;
    }
}
