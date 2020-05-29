package com.example.rfid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button login;
    private int counter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.one);
        Password = (EditText)findViewById(R.id.pass);
        login = (Button)findViewById(R.id.log);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checker(Username.getText().toString(), Password.getText().toString());
            }
        });


    }

    private void checker(String un, String up){
        if((un.equals("rfid")) && (up.equals("ford"))){
            Intent intent = new Intent(MainActivity.this, Screentwo.class);
            startActivity(intent);
        }else{
            counter--;

            if(counter == 0){
                login.setEnabled(false);
            }
        }
    }
}
