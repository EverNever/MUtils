package com.mutils.library.util;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

/**
 * 下载工具类
 */
public class DownloadUtil {
    /**
     * 启动下载
     * @param context
     * @param url
     */
    public static void download(Context context, String url){
        DownloadManager downloadManager =
                (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        String fileName = url.substring(url.lastIndexOf("/") + 1);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE
                |DownloadManager.Request.NETWORK_WIFI);
        request.setVisibleInDownloadsUi(false);
        request.setNotificationVisibility(DownloadManager.Request
                .VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
        downloadManager.enqueue(request);
    }
}
