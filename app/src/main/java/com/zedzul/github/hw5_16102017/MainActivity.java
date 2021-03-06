package com.zedzul.github.hw5_16102017;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = BuildConfig.BASE_URL;
    private static final String UPDATE_URL = BuildConfig.UPDATE_URL;

    String checkUpdate() {
        final String[] pError = new String[1];
        final AsyncCheckUpdateTask pAsyncCheckUpdateTask = new AsyncCheckUpdateTask() {
            @Override
            protected void onPostExecute(final String result) {
                pError[0] = mChecker.getError();
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                if (mChecker.getError() == null || mChecker.getError() == "") {
                    if (mChecker.getCurrentVersion() > BuildConfig.VERSION_CODE) {
                        VersionDialog(alertDialogBuilder, mChecker);
                    }
                }

            }
        };
        pAsyncCheckUpdateTask.execute(new Pair<>(getApplicationContext(), BASE_URL));
        return pError[0];
    }

    void VersionDialog(final AlertDialog.Builder pAlertDialogBuilder, final IUpdateChecker pChecker) {
        if (pChecker.isForceUpdate()) {
            pAlertDialogBuilder
                    .setTitle("Necessary to update")
                    .setMessage("You should update your application here: " + UPDATE_URL)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        public void onClick(final DialogInterface dialog, final int id) {
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    });
        } else {
            pAlertDialogBuilder
                    .setTitle("You want to update?")
                    .setMessage("Do you want to update application? ")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        public void onClick(final DialogInterface dialog, final int id) {
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {

                        public void onClick(final DialogInterface dialog, final int id) {
                            dialog.cancel();
                        }
                    });
        }
        pAlertDialogBuilder
                .setCancelable(false)
                .create()
                .show();
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View pButtonCheckUpdate = findViewById(R.id.update_button);
        pButtonCheckUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View pView) {
                checkUpdate();
            }
        });

    }
}
