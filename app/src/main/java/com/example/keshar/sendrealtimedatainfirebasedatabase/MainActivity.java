package com.example.keshar.sendrealtimedatainfirebasedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    private EditText etName,etValue;
    private Button btnSend;
    private Firebase firebaseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        etName=findViewById(R.id.et_name);
        etValue=findViewById(R.id.name);
        btnSend=findViewById(R.id.btn_send);
        firebaseUrl=new Firebase("https://applicationdemo-eff34.firebaseio.com/");


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=etValue.getText().toString().trim();
                String name=etName.getText().toString().trim();
                Firebase firebase=firebaseUrl.child("Name").child(name);
                firebase.setValue(value);

            }
        });

    }
}
