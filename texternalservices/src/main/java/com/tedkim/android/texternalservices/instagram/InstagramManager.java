package com.tedkim.android.texternalservices.instagram;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.tedkim.android.texternalservices.config.ExternalServiceConfig;
import com.tedkim.android.texternalservices.utils.ExternalServiceUtils;

import java.io.File;

/**
 * Instagram Manger
 * Created by Ted
 */

public class InstagramManager {

    private static final String INSTAGRAM_URL = "http://www.instagram.com/";
    private static final String INSTAGRAM_PACKAGE = "com.instagram.android";

    public static void openApp(Activity activity) {
        if (ExternalServiceUtils.checkInstalled(activity, INSTAGRAM_PACKAGE)) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType(ExternalServiceConfig.INTENT_TEXT_TYPE);
            intent.putExtra(Intent.EXTRA_TEXT, " ");
            intent.putExtra(Intent.EXTRA_SUBJECT, " ");
            intent.setPackage(INSTAGRAM_PACKAGE);
            activity.startActivity(intent);


//            Uri uri = Uri.parse("http://instagram.com/");
//            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
//
//            likeIng.setPackage("com.instagram.android");
//
//            try {
//                activity.startActivity(likeIng);
//            } catch (ActivityNotFoundException e) {
//                activity.startActivity(new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("http://instagram.com/xxx")));
//            }

////            Intent intent = new Intent(Intent.ACTION_SEND);
////            intent.setPackage(INSTAGRAM_PACKAGE);
////            activity.startActivity(intent);
//            Intent intent = new Intent(Intent.ACTION_VIEW);
////            intent.setType(ExternalServiceConfig.INTENT_MAIN);
////            intent.setPackage(INSTAGRAM_PACKAGE);
//            intent.setData(Uri.parse("http://www.facebook.com"));
//            activity.startActivity(intent);
        } else {

        }
    }

    /**
     * Check instagram app installed
     *
     * @param context context
     * @return installed
     */
    public static boolean checkInstalledApp(Context context) {
        return ExternalServiceUtils.checkInstalled(context, INSTAGRAM_PACKAGE);
    }

    /**
     * Open instagram web site
     *
     * @param context context
     */
    public static void openWebSite(Context context) {
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(INSTAGRAM_URL)));
    }

    // =============================================================================
    // Photo share
    // =============================================================================
    /**
     * Share photo using photo path
     *
     * @param photoPath photo path
     */
    public static void sharePhoto(Activity activity, String photoPath) {
        File media = new File(photoPath);
        Uri uri = Uri.fromFile(media);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(ExternalServiceConfig.INTENT_IMAGE_TYPE);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setPackage(INSTAGRAM_PACKAGE);
        share(activity, intent);
    }

    /**
     * Share photo using file
     *
     * @param file photo file
     */
    public static void sharePhoto(Activity activity, File file) {
        Uri uri = Uri.fromFile(file);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(ExternalServiceConfig.INTENT_IMAGE_TYPE);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setPackage(INSTAGRAM_PACKAGE);
        share(activity, intent);
    }

    /**
     * Share photo using uri
     *
     * @param uri photo uri
     */
    public static void sharePhoto(Activity activity, Uri uri) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(ExternalServiceConfig.INTENT_IMAGE_TYPE);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setPackage(INSTAGRAM_PACKAGE);
        share(activity, intent);
    }

    // =============================================================================
    // Video share
    // =============================================================================
    /**
     * Share video
     *
     * @param videoPath video path
     */
    public static void shareVideo(Activity activity, String videoPath) {
        File media = new File(videoPath);
        Uri uri = Uri.fromFile(media);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(ExternalServiceConfig.INTENT_VIDEO_TYPE);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setPackage(INSTAGRAM_PACKAGE);
        share(activity, intent);
    }

    /**
     * Share video
     *
     * @param file video file
     */
    public static void shareVideo(Activity activity, File file) {
        Uri uri = Uri.fromFile(file);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(ExternalServiceConfig.INTENT_VIDEO_TYPE);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setPackage(INSTAGRAM_PACKAGE);
        share(activity, intent);
    }

    /**
     * Share video
     *
     * @param uri video uri
     */
    public static void shareVideo(Activity activity, Uri uri) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(ExternalServiceConfig.INTENT_VIDEO_TYPE);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setPackage(INSTAGRAM_PACKAGE);
        share(activity, intent);
    }

    // =============================================================================
    // Share
    // =============================================================================
    /**
     * FIXME not installed check
     * Instagram share
     */
    private static void share(Activity activity, Intent intent) {
        if (ExternalServiceUtils.checkInstalled(activity, INSTAGRAM_PACKAGE))
            activity.startActivity(intent);
    }


}
