package com.zedzul.github.hw5_16102017;

import com.example.ConfigApi;
import com.example.ConfigGson;
import com.google.gson.GsonBuilder;
import com.zedzul.github.hw5_16102017.http.HttpClient;

import java.io.InputStream;
import java.io.InputStreamReader;

class UpdateChecker implements IUpdateChecker {

    private final String BASE_URL;
    private final ConfigGson mConfig;

    UpdateChecker(final String pBaseUrl) {
        BASE_URL = pBaseUrl;
        final String url = new ConfigApi(BASE_URL).getConfigUrl();
        final ConfigurationListener listener = new ConfigurationListener();
        new HttpClient().request(url, listener);
        mConfig = listener.getConfig();
    }

    String fakeCurentVersion(final String pFake) {
        return pFake;
    }

    @Override
    public Boolean isForceUpdate() {
        return mConfig.isForceUpdate();
    }

    @Override
    public Integer getCurrentVersion() {
        return mConfig.getCurrentAppVersion();
    }

    @Override
    public String getError() {
        return mConfig.getError();
    }

    private static class ConfigurationListener implements HttpClient.IResponseListener {

        private ConfigGson mConfig;
        private Throwable mThrowable;

        ConfigGson getConfig() {
            return mConfig;
        }

        @Override
        public void onResponse(final InputStream pInputStream) {
            InputStreamReader inputStreamReader = null;
            try {
                inputStreamReader = new InputStreamReader(pInputStream);
                mConfig = new GsonBuilder()
                        .setLenient()
                        .create()
                        .fromJson(inputStreamReader, ConfigGson.class);
            } finally {
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (final Exception e) {
                        e.getMessage();
                    }
                }
            }
        }

        public Throwable getThrowable() {
            return mThrowable;
        }
    }
}
