package com.example.krishisahayak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    Button cont;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Home.class);
                startActivity(i);
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
    }
}