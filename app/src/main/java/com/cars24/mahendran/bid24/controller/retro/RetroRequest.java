/*
 * Copyright (c) 2016 - 2017 1Banyan Inc. - All rights reserved.
 * Unauthorized copying of this file is strictly prohibited
 * Proprietary and confidential
 */

package com.cars24.mahendran.bid24.controller.retro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MahendraRaj on 05-09-2016.
 */
public class RetroRequest {
    @SerializedName("session-id")
    @Expose
    private String sessionId;

    /**
     * @return The sessionId
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId The sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
