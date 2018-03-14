package irfan.smsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText sender,receiver,message;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sender=(EditText) findViewById(R.id.sender);
        receiver=(EditText) findViewById(R.id.receive);
        message=(EditText) findViewById(R.id.message);

        send=(Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SENDER=sender.getText().toString();
                String RECEIVER=receiver.getText().toString();
                String MESSAGE=message.getText().toString();

                Intent i=new Intent(MainActivity.this,SendActivity.class);
                i.putExtra("SENDER",SENDER);
                i.putExtra("RECEIVER",RECEIVER);
                i.putExtra("MESSAGE",MESSAGE);
                startActivity(i);

            }
        });


    }
}
