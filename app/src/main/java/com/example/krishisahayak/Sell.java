package com.example.krishisahayak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.krishisahayak.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sell extends AppCompatActivity {

    ActivityMainBinding binding;
    String name,product,pno,price,desc;
    EditText namee,pname,pnoo,pricee,descc;
    FirebaseDatabase db;
    Button sell;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
//        binding=ActivityMainBinding.inflate(getLayoutInflater());
        sell=findViewById(R.id.sell_btn);
        namee=findViewById(R.id.seller_name);
        pnoo=findViewById(R.id.pno);
        pricee=findViewById(R.id.price);
        pname=findViewById(R.id.product_name);
        descc=findViewById(R.id.description);
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=namee.getText().toString();
                product=pname.getText().toString();
                pno=pnoo.getText().toString();
                price=pricee.getText().toString();
                desc=descc.getText().toString();
                if(!name.isEmpty() && !product.isEmpty() &&!pno.isEmpty() && !price.isEmpty() && !desc.isEmpty()){
                    Sellers seller=new Sellers(name,pno,product,price,desc);
                    db=FirebaseDatabase.getInstance();
                    reference=db.getReference("Sellers");
                    reference.child(name).setValue(seller).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            namee.setText("");
                            pname.setText("");
                            pnoo.setText("");
                            pricee.setText("");
                            descc.setText("");
                            Toast.makeText(Sell.this, "Your product is added for sale successfully!", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else{
                    Toast.makeText(Sell.this, "Enter all details", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}