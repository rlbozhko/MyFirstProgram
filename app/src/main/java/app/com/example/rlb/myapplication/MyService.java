package app.com.example.rlb.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

        final String LOG_TAG = "~~~~ROST APP~~~~";
        MainActivity mainActivity;

        public MyService() {
        }

        @Override
        public IBinder onBind(Intent intent) {
            Log.d(LOG_TAG, "onBind");
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            Log.d(LOG_TAG, "onStartCommand");
            mainActivity = ((MyApplication) getApplicationContext()).mainActivity;
            mainActivity.setTextToEditText("Start Service");
            return super.onStartCommand(intent, flags, startId);

        }

        @Override
        public void onCreate() {
            super.onCreate();
            Log.d(LOG_TAG, "onCreate");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mainActivity.setTextToEditText("Stop Service");
            Log.d(LOG_TAG, "onDestroy");
        }
    }
