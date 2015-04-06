package app.com.example.rlb.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener {

    private EditText etReceivedBroadcast;
    private Button btnSendBroadcast;
    private Button startServiceButton;
    private Button stopStopServiceButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServiceButton = (Button) findViewById(R.id.btn_start_service);
        startServiceButton.setOnClickListener(this);

        stopStopServiceButton = (Button) findViewById(R.id.btn_stop_service);
        stopStopServiceButton.setOnClickListener(this);

        btnSendBroadcast = (Button) findViewById(R.id.btn_send_broadcast);
        btnSendBroadcast.setOnClickListener(this);

        etReceivedBroadcast = (EditText) findViewById(R.id.etReceivedBroadcast);


        MyApplication myApplication = (MyApplication) this.getApplicationContext();
        myApplication.mainActivity = this;


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    public void setTextToEditText(String text){
        if(text!=null)
        etReceivedBroadcast.setText(text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_service:
            startService(new Intent(MainActivity.this,MyService.class));
                break;
            case R.id.btn_stop_service:
                stopService(new Intent(MainActivity.this,MyService.class));

                break;
            case R.id.btn_send_broadcast:
                Intent intent = new Intent();
                intent.putExtra("status",true);
                intent.putExtra("data","onClick send broadcast");
                intent.setAction("app.com.example.myCustomBroadcast");
                sendBroadcast(intent);

                break;

            default:
                break;
        }

    }

}