package com.example.manit_stu_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button button,button5;
    TextView textView,textView13;
    TextInputLayout cn,ds,ai,cd,os,stat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button4);
        textView=findViewById(R.id.textView12);
        textView13=findViewById(R.id.textView13);
        button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cn=findViewById(R.id.user2);
                ds=findViewById(R.id.user3);
                ai=findViewById(R.id.user4);
                cd=findViewById(R.id.user5);
                os=findViewById(R.id.user6);
                stat=findViewById(R.id.user7);
                int cna=Integer.parseInt(cn.getEditText().getText().toString());
                int dsa=Integer.parseInt(ds.getEditText().getText().toString());
                int aia=Integer.parseInt(ai.getEditText().getText().toString());
                int cda=Integer.parseInt(cd.getEditText().getText().toString());
                int osa=Integer.parseInt(os.getEditText().getText().toString());
                int stata=Integer.parseInt(stat.getEditText().getText().toString());
                textView.setVisibility(View.VISIBLE);
                textView13.setVisibility(View.VISIBLE);
                textView.setText("Total classes scheduled of cn,ds,ai,cd,os,stat is 3,3,6,6,6,6 respectivwly and the percentage attendance is "+ cna/3.0+", "+ dsa/3.0+", "+ aia/6.0+", "+ cda/6.0+", "+ osa/6.0+", "+ stata/6.0);
                //9,9,11,8,8,11
                textView13.setText("The no. of attendance required in cn,ds,ai,cd,os,stat is "+(Math.ceil(12*(0.75))-cna)+", "+(Math.ceil(12*(0.75))-dsa)+", "+(Math.ceil(17*(0.75))-aia)+", "+(Math.ceil(14*(0.75))-cda)+", "+(Math.ceil(14*(0.75))-osa)+", "+(Math.ceil(17*(0.75))-stata));
            }
        });
                button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,profileAndSet.class);
                startActivity(intent);
            }
        });
    }
}