package com.integro.sjii.firebase;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.integro.sjii.NewsActivity;
import com.integro.sjii.NotificationActivity;
import com.integro.sjii.R;
import com.integro.sjii.models.News;
import com.integro.sjii.models.Notifications;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG = "MyFirebaseMsgService";
    public static final String TYPE = "type";
    public static final String BODY = "body";
    public static final String NOTIFICATION_CHANNEL_ID = "4655";
    public static final String NOTIFICATION_CHANNEL_NAME = "notification_channel_name";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "data payload: " + remoteMessage.getData());
        }
        sendNotification(remoteMessage.getData());
    }

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void sendNotification(Map<String, String> data) {
        try {
            Log.d(TAG, "In try ");
            int type = Integer.parseInt(data.get(TYPE));
            String body = data.get(BODY);
            Intent intent = null;
            String title = null;
            String img = null;
            String description = null;
            NotificationCompat.Builder mBuilder;
            PendingIntent pendingIntent;

            if (type == 1) {
                Notifications notificationItem = (Notifications) new Gson().fromJson(body, Notifications.class);
                title = notificationItem.getTitle();
                description = notificationItem.getDescription();
                intent = new Intent(this, NotificationActivity.class);
                intent.putExtra("tag","NOTIFICATIONS");
            }
            if (type == 2) {
                News newsItem = (News) new Gson().fromJson(body, News.class);
                img = newsItem.getImage().toString();
                title = newsItem.getTitle();
                description = newsItem.getDescription();
                intent = new Intent(this, NewsActivity.class);
            }

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                int importanceDefault = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, importanceDefault);
                channel.setDescription("description");
                notificationManager.createNotificationChannel(channel);
            }
            intent.putExtra(TAG, true);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

            mBuilder = new NotificationCompat.Builder(this);
            mBuilder.setDefaults(android.app.Notification.DEFAULT_SOUND |
                    android.app.Notification.DEFAULT_LIGHTS |
                    android.app.Notification.DEFAULT_VIBRATE);
            mBuilder.setContentTitle(title);
            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            mBuilder.setContentText(description);
            mBuilder.setSmallIcon(R.drawable.logo2);
            mBuilder.setAutoCancel(true);
            mBuilder.setPriority(android.app.Notification.PRIORITY_HIGH);
            mBuilder.setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE);
            mBuilder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            mBuilder.setContentIntent(pendingIntent);
            //setting BigPicture in Notifications
            Bitmap bitmap_image = getBitmapFromURL(img);
            if (bitmap_image == null) {
                mBuilder.setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(description));
            } else {
                Log.d("IMAGE", "" + bitmap_image);
                NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle().bigPicture(bitmap_image);
                mBuilder.setStyle(style);
                mBuilder.setLargeIcon(bitmap_image);
            }

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
            notificationManagerCompat.notify(Integer.parseInt("001"), mBuilder.build());

        } catch (Exception e) {

        }
    }

    private Bitmap getBitmapFromURL(String strURL) {
        try {
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

