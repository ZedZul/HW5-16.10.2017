package com.zedzul.github.hw5_16102017;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

class AsyncCheckUpdateTask extends AsyncTask<Pair<Context, String>, Void, String> {

    UpdateChecker mChecker;

    @SafeVarargs
    @Override
    protected final String doInBackground(final Pair<Context, String>... params) {

        final String baseUrl = params[0].second;

        mChecker = new UpdateChecker(baseUrl);

        return mChecker.toString();
    }

}
