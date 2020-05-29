package com.example.rfid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ret extends AppCompatActivity {

    ListView listview;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<Variable> list;
    ArrayAdapter<Variable> adapter;
    Variable variable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ret);

        variable = new Variable();
        listview = (ListView) findViewById(R.id.lv);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Variable");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<Variable>(this, R.layout.attdetail, R.id.detail, list);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){

                    variable = ds.getValue(Variable.class);
                    list.add(variable);


                }
                listview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
