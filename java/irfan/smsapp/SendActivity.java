package irfan.smsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SendActivity extends AppCompatActivity {
TextView sender,receiver,message;
    EditText mo;
    Button send_sms;
    SmsManager sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        sender=(TextView) findViewById(R.id.sender);
        receiver=(TextView) findViewById(R.id.receiver);
        message=(TextView) findViewById(R.id.message);
        mo=(EditText) findViewById(R.id.editTextNumber);
        send_sms=(Button) findViewById(R.id.sendSms);
        Intent i=getIntent();


        String SENDER=i.getStringExtra("SENDER");
        sender.setText(SENDER);

        String RECEIVER=i.getStringExtra("RECEIVER");
        receiver.setText(RECEIVER);


        String MESSAGE=i.getStringExtra("MESSAGE");
        message.setText(MESSAGE);

        final String all_data=(SENDER + RECEIVER + MESSAGE);

        send_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(mo.getText().toString(),all_data);
            }
        });

    }
    private  void sendMessage(String mo,String message)
    {
        sms=SmsManager.getDefault();
        sms.sendTextMessage(mo,null,message,null,null);
        Toast.makeText(getApplicationContext(),"SMS Send",Toast.LENGTH_SHORT).show();
    }
}
