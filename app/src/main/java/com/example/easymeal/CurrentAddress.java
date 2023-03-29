package com.example.easymeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.easymeal.databinding.ActivityCurrentAddressBinding;
import com.example.easymeal.databinding.ActivityUserDetailBinding;

public class CurrentAddress extends AppCompatActivity {

    ActivityCurrentAddressBinding binding;


    public void FieldValidation() {

        if(binding.deliveryAddressFullName.getText().toString().isEmpty()){
            binding.deliveryAddressFullName.setError("cannot be empty");
            binding.deliveryAddressFullName.requestFocus();
        }

        else if(binding.deliveryAddressPhone.getText().toString().isEmpty()){
            binding.deliveryAddressPhone.setError("cannot be empty");
            binding.deliveryAddressPhone.requestFocus();
        }
        else if (binding.deliveryAddressPhone.length() < 10) {
            if (binding.deliveryAddressPhone.length() == 9)
                Toast.makeText(getApplicationContext(), Integer.toString(10 - binding.deliveryAddressPhone.length()) + " digit is missing", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), Integer.toString(10 - binding.deliveryAddressPhone.length()) + " digits are missing", Toast.LENGTH_SHORT).show();
        }

        else if (binding.deliveryAddressHouse.getText().toString().isEmpty()) {
            binding.deliveryAddressHouse.setError("Can not Empty");
            binding.deliveryAddressHouse.requestFocus();


        } else if (binding.deliveryAddressArea.getText().toString().isEmpty()) {
            binding.deliveryAddressArea.setError("Can not Empty");
            binding.deliveryAddressArea.requestFocus();
        } else if (binding.deliveryAddressCity.getText().toString().isEmpty()) {
            binding.deliveryAddressCity.setError("can not empty");
            binding.deliveryAddressCity.requestFocus();

        }
        else if (binding.deliveryAddressState.getText().toString().isEmpty()) {
            binding.deliveryAddressState.setError("can not empty");
            binding.deliveryAddressState.requestFocus();
        }

        else if (binding.deliveryAddressPincode.getText().toString().isEmpty()) {
            binding.deliveryAddressPincode.setError("can not empty");
            binding.deliveryAddressPincode.requestFocus();
        }
        else {
            Intent intent=new Intent(CurrentAddress.this,CheckoutActivity.class);
            startActivity(intent);



        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCurrentAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.deliveryAddressButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                FieldValidation();


            }


        });


    }
}