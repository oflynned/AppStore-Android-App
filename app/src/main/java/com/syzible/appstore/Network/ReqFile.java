package com.syzible.appstore.Network;

import android.content.Context;

import com.syzible.appstore.Helpers.System;
import com.syzible.appstore.Objects.App;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ed on 16/12/2016
 */

public class ReqFile extends GetRequest<File> {
    private App app;
    private Context context;

    public ReqFile(NetworkCallback<File> networkCallback, App app, Context context) {
        super(networkCallback, app.getApkUrl());
        this.app = app;
        this.context = context;
    }

    @Override
    public File transferData() {
        try {
            switch (getConnection().getResponseCode()) {
                case 200:
                case 304:
                    String destination = System.getDownloadsPath(context);
                    File dir = new File(destination);
                    dir.mkdirs();

                    File apkFile = new File(dir, System.getPackageApk(app));

                    FileOutputStream outputStream = new FileOutputStream(apkFile);
                    InputStream inputStream = getConnection().getInputStream();

                    byte[] buffer = new byte[1024];
                    int n;
                    while((n = inputStream.read(buffer)) != -1) outputStream.write(buffer, 0, n);

                    outputStream.close();
                    inputStream.close();

                    apkFile.createNewFile();

                    return apkFile;
                case 404:
                case 500:
                    break;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
