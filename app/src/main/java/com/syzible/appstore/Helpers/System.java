package com.syzible.appstore.Helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.syzible.appstore.Objects.App;

import java.io.File;

/**
 * Created by ed on 16/12/2016
 */

public class System {
    public static void installApk(App app, Context context) {
        File apk = new File(getDownloadsPath(context), getPackageApk(app));
        Intent installIntent = new Intent(Intent.ACTION_VIEW)
                .setDataAndType(Uri.fromFile(apk), "application/vnd.android.package-archive")
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(installIntent);
    }

    public static void updateApk(App app, Context context) {

    }

    public static void uninstallApk(App app, Context context) {
        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE);
        uninstallIntent.setData(Uri.parse("package:" + app.getAppPackage()));
        uninstallIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(uninstallIntent);
    }

    public static String getDownloadsPath(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AppStore/";
    }

    public static String getPackageApk(App app) {
        return app.getAppPackage() + ".apk";
    }
}
