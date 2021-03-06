package com.solderbyte.openfit;

import java.util.Calendar;
import java.util.Date;

import com.solderbyte.openfit.util.OpenFitIntent;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Cronjob {
    private static final String LOG_TAG = "OpenFit:Cronjob";

    private static AlarmManager alarmManager = null;
    private static Intent alarmIntent = null;
    private static PendingIntent alarmPendingIntent = null;
    private static boolean isAlarm = false;

    public static void init(Context context) {
        Log.d(LOG_TAG, "Initializing Cronjob");
        alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmIntent = new Intent(OpenFitIntent.INTENT_SERVICE_CRONJOB);
        alarmPendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public static void start() {
        if(alarmPendingIntent != null && isAlarm == false) {
            Log.d(LOG_TAG, "Starting Cronjob");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)+1);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Date cronDate = new Date(cal.getTimeInMillis());

            Log.d(LOG_TAG, "Cronjob schedule to start at: " + cronDate);
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_HOUR, alarmPendingIntent);
            isAlarm = true;
            //alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, 1000, 1000, alarmPendingIntent);
        }
    }

    public static void stop() {
        if(alarmManager!= null) {
            Log.d(LOG_TAG, "Stopping Cronjob");
            alarmManager.cancel(alarmPendingIntent);
            isAlarm = false;
        }
    }
}
