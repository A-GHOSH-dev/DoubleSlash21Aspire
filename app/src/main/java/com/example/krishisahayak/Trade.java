package com.example.krishisahayak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Trade extends AppCompatActivity {
    TextView t;
    Button buy,sell;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);
//        FragmentManager fragmentManager =getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        FarmersCorner farmersCorner= new FarmersCorner();
//        fragmentTransaction.add(R.id.frame,farmersCorner);
//        fragmentTransaction.commit();
        Intent intent = getIntent();
        t=findViewById(R.id.textView5);



        sell=findViewById(R.id.sell);
        int selectedCard = intent.getExtras().getInt("selectedCard");
        switch(selectedCard){
            case 0:
                t.setText("Agriculture Products");
                break;
            case 1:
                t.setText("Aquaculture Products");
                break;
            case 2:
                t.setText("Apiculture Products");
                break;

            case 3:
                t.setText("Livestock Products");
                break;
        }




    }
}