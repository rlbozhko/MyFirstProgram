package app.com.example.rlb.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MyBroadCastReceiver extends BroadcastReceiver {
 
    @Override
    public void onReceive(Context context, Intent intent) {
     MainActivity mainActivity = ((MyApplication) context.getApplicationContext()).mainActivity;
     Bundle extras =  intent.getExtras();
        boolean status = false;
        String someText = "";
        if(extras!=null){
            status = extras.getBoolean("status",false);
            someText = extras.getString("data","empty data");


        }
        if(status)
            mainActivity.setTextToEditText("My Broadcast name  is "+ MyBroadCastReceiver.this.getClass().getName()+ "\n" + "  and my data =  "+ someText);

    }
     
}