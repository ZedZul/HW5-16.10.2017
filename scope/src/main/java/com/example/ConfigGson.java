package com.example;

import com.google.gson.annotations.SerializedName;

public class ConfigGson {

    @SerializedName("current_app_version")
    private Integer mCurrentAppVersion;
    @SerializedName("force_update")
    private Boolean mForceUpdate;
    @SerializedName("error")
    private String mError;

    public ConfigGson() {
    }

    public ConfigGson(final Integer pCurrentAppVersion, final Boolean pForceUpdate, final String pError) {
        mCurrentAppVersion = pCurrentAppVersion;
        mForceUpdate = pForceUpdate;
        mError = pError;
    }

    public Integer getCurrentAppVersion() {
        return mCurrentAppVersion;
    }

    public void setCurrentAppVersion(final Integer pCurrentAppVersion) {
        mCurrentAppVersion = pCurrentAppVersion;
    }

    public boolean isForceUpdate() {
        return mForceUpdate;
    }

    public void setForceUpdate(final Boolean pForceUpdate) {
        mForceUpdate = pForceUpdate;
    }

    public String getError() {
        return mError;
    }

    public void setError(final String pError) {
        mError = pError;
    }
}
