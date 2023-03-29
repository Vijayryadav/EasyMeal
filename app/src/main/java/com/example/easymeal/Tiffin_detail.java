package com.example.easymeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tiffin_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiffin_detail);
        Intent intent = getIntent();
        String tiffinCenterName = intent.getStringExtra("tiffin_center_name");
        String tiffinCenterAddress = intent.getStringExtra("tiffin_center_address");
        String tiffinCenterPrice = "" +
                "" +
                "" +
                "" +
                "" +
                "Pricing starts from "+ String.valueOf(intent.getIntExtra("tiffin_center_price",60));

        // Do something with the retrieved extras
        TextView nameTextView = findViewById(R.id.tiffin_center_name);
        TextView addressTextView = findViewById(R.id.tiffin_center_address);
        TextView priceTextView = findViewById(R.id.tiffin_center_pricing);

        nameTextView.setText(tiffinCenterName);
        addressTextView.setText(tiffinCenterAddress);
        priceTextView.setText(String.valueOf(tiffinCenterPrice));

        findViewById(R.id.add_to_cart_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(Tiffin_detail.this,CurrentAddress.class);
                startActivity(intent);

            }
        });
    }
}