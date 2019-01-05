/*
 * Copyright (c) 2016 - 2017 1Banyan Inc. - All rights reserved.
 * Unauthorized copying of this file is strictly prohibited
 * Proprietary and confidential
 */

package com.cars24.mahendran.bid24.controller.retro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RetroResponse {


    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
