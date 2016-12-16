package com.syzible.appstore.Helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * Created by ed on 16/12/2016
 */

public class System {
    public static void installApk(String packageName, Context context) {
        File apk = new File(packageName);
        Intent installIntent = new Intent(Intent.ACTION_VIEW);
        installIntent.setDataAndType(Uri.fromFile(apk), "application/vnd.android.package-archive");
        context.startActivity(installIntent);
    }

    public static void updateApk(String packageName, Context context) {

    }

    public static void uninstallApk(String packageName, Context context) {
        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE);
        uninstallIntent.setData(Uri.parse("package:" + packageName));
        context.startActivity(uninstallIntent);
    }
}
