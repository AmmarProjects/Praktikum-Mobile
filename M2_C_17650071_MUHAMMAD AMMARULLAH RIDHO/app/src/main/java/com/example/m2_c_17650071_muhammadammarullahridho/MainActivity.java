package com.example.m2_c_17650071_muhammadammarullahridho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_HASIL="state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth=(EditText)findViewById(R.id.edt_width);
        edtHeight=(EditText)findViewById(R.id.edt_height);
        edtLength=(EditText)findViewById(R.id.edt_length);
        tvResult=(TextView)findViewById(R.id.tv_result);
        btnCalculate=(Button)findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }
    }

    @Override
    public void onClick(View v){
       if (v.getId()==R.id.btn_calculate){
           String length = edtLength.getText().toString().trim();
           String width = edtWidth.getText().toString().trim();
           String height = edtHeight.getText().toString().trim();

           boolean isEmptyFields = false;

           if (TextUtils.isEmpty(length)){
               isEmptyFields = true;
               edtLength.setError("Field Ini Tidak Boleh Kosong");
           }

           if (TextUtils.isEmpty(width)){
               isEmptyFields = true;
               edtWidth.setError("Field Ini Tidak Boleh Kosong");
           }

           if (TextUtils.isEmpty(height)){
               isEmptyFields = true;
               edtHeight.setError("Field Ini Tidak Boleh Kosong");
           }

           if(!isEmptyFields){
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l*w*h;
                tvResult.setText(String.valueOf(volume));
           }
       }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(STATE_HASIL, tvResult.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
