package com.example.manit_stu_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profileAndSet extends AppCompatActivity {
    TextInputLayout npass;
    Button button,button3;
    Switch swit;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_and_set);
        textView=findViewById(R.id.textView2);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser() ;
        button=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        npass=findViewById(R.id.user1);
        swit=findViewById(R.id.switch1);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profileAndSet.this,login.class);
                startActivity(intent);
                finish();
            }
        });
       swit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               swit.setText("Dark Mode");
           }
       });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    user.updatePassword(npass.getEditText().getText().toString());
                    Toast.makeText(profileAndSet.this,  "Successfully done the operation "+ npass.getEditText().getText().toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(profileAndSet.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}