package com.example.rfid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Screentwo extends AppCompatActivity {

    private Button att;
    private Button rf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screentwo);

        att = (Button)findViewById(R.id.button);
        rf = (Button)findViewById(R.id.button2);

        att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screentwo.this, test.class);
                startActivity(intent);
            }
        });

        rf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screentwo.this, ret.class);
                startActivity(intent);
            }
        });




    }
}
