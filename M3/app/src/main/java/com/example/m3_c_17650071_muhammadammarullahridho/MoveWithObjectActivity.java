package com.example.m3_c_17650071_muhammadammarullahridho;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON="extra_person";
    TextView tvObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject=findViewById(R.id.tv_object_received);


        Person person= getIntent().getParcelableExtra(EXTRA_PERSON);
        String text="Name: "+person.getName()+", \nEmail: "+person.getEmail()+", \nAge: "+person.getAge()+", \nLocation: "+person.getCity();
        tvObject.setText(text);

    }
}
