package com.example.krishisahayak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button cont,signIn;
    EditText editTextEmail,editTextPassword;
    TextView textView,register;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    Boolean state=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        editTextEmail=findViewById(R.id.mail);
        editTextPassword=findViewById(R.id.pass);
        mAuth=FirebaseAuth.getInstance();
        signIn=findViewById(R.id.login);
        progressBar=findViewById(R.id.progressBar);


        register=findViewById(R.id.reg);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state){
                Intent i =new Intent(MainActivity.this,Home.class);
                startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please Login First!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent i =getIntent();
        int pos=i.getIntExtra("key",0);
        if(pos==2){
            Toast.makeText(MainActivity.this,"it worked!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,streeKrishi.class);
            startActivity(intent);
        }
        YoYo.with(Techniques.FadeIn)
             .duration(2000)
             .repeat(1)
             .playOn(textView);
        register.setOnClickListener(this);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reg:
                Intent i = new Intent(this,Register.class);
                startActivity(i);
                break;
            case R.id.login:
                userLogin();
        }
    }

    private void userLogin() {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        if(email.isEmpty()){
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please Enter a valid email!");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "User verified! Click Continue Button", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    state=true;
                }else{
                    Toast.makeText(MainActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}