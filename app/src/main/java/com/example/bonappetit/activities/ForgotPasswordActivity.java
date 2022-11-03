package com.example.bonappetit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bonappetit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailid;
    TextView gobacktologin;
    FirebaseAuth firebaseAuth;
    Button updatepass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailid = findViewById(R.id.email_id);
        gobacktologin = findViewById(R.id.textView14);
        firebaseAuth=FirebaseAuth.getInstance();
        updatepass = findViewById(R.id.updatepass);

    }
    public void loginpage(View view) {
        startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
    }

    public void update(View view) {
        String mail = emailid.getText().toString();
        if (mail.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter your Email", Toast.LENGTH_SHORT).show();
        } else {
            fogetPass();
        }
    }

    private void fogetPass() {
        firebaseAuth.sendPasswordResetEmail(emailid.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ForgotPasswordActivity.this,"Check your email",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(ForgotPasswordActivity.this,"Error."+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
