package com.example;

public class ConfigApi {

    private static final String CONFIG_PATH = "config";

    private final String mBasePath;

    public ConfigApi(final String pBasePath) {
        mBasePath = pBasePath.charAt(pBasePath.length() - 1) != '/' ? pBasePath + "/" : pBasePath;

    }

    public String getConfigUrl() {
        return mBasePath + CONFIG_PATH;
    }

}
