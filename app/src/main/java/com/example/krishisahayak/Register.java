package com.example.krishisahayak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;
    EditText name,age,email,pass;
    Button reg;
    ProgressBar progressBar;
    TextView banner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        name=findViewById(R.id.name);
        age=findViewById(R.id.agee);
        email=findViewById(R.id.eemail);
        pass=findViewById(R.id.passs);
        reg=findViewById(R.id.reg_btn);
        banner=findViewById(R.id.back);
        progressBar=findViewById(R.id.progressBar2);
        banner.setOnClickListener(this);
        reg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.back:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.reg_btn:
                registerUser();
        }

    }

    private void registerUser() {
        String mail = email.getText().toString().trim();
        String password = pass.getText().toString().trim();
        String fullname = name.getText().toString().trim();
        String agee = age.getText().toString().trim();
        if(fullname.isEmpty()){
            name.setError("Full name is required!");
            name.requestFocus();
            return;
        }
        if(agee.isEmpty()){
            age.setError("Age is required!");
            age.requestFocus();
            return;
        }
        if(mail.isEmpty()){
            email.setError("Email Address is required!");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email.setError("Enter a valid Email address");
            email.requestFocus();
            return;
        }
        if(password.isEmpty()){
            pass.setError("Password is required!");
            pass.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(mail,password)
             .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         User user=new User(fullname,agee,mail);
                         FirebaseDatabase.getInstance().getReference("Users")
                                 .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                 .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                             @Override
                             public void onComplete(@NonNull Task<Void> task) {
                                 if(task.isSuccessful()){
                                     Toast.makeText(Register.this,"User has been registered successfully!",Toast.LENGTH_SHORT).show();
                                     progressBar.setVisibility(View.GONE);

                                 }else{
                                     Toast.makeText(Register.this,"Failed to register. Try again!",Toast.LENGTH_SHORT).show();
                                     progressBar.setVisibility(View.GONE);
                                 }

                             }
                         });
                     }else{
                         Toast.makeText(Register.this,"Failed to register. Try again!",Toast.LENGTH_SHORT).show();
                         progressBar.setVisibility(View.GONE);
                     }

                 }
             });
    }
}