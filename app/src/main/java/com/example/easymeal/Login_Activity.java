package com.example.easymeal;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.annotation.SuppressLint;
import android.text.TextPaint;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.easymeal.R;

import com.example.easymeal.databinding.ActivityLoginBinding;

public class Login_Activity extends AppCompatActivity {

    ActivityLoginBinding binding;

    private void setoncicklisteners(){
        binding.password.setOnClickListener(view -> showpass());
        binding.signinbutton.setOnClickListener(view -> startActivity(new Intent(Login_Activity.this,SignUp.class)));

        binding.forgotpass.setOnClickListener(view -> {
            Intent intent=new Intent(Login_Activity.this, SignUp.class);
            intent.putExtra("id","Forgot Password");
            startActivity(intent);
        });

        binding.create.setOnClickListener(view -> {
            Intent intent=new Intent(Login_Activity.this,SignUp.class);
            startActivity(intent);
        });

    }

    int i=1;

    private void showpass(){
        if(i == 1) {
            binding.passwordshow.setImageResource(R.drawable.ic_eye_close);
            i=0;
        }else{
            binding.passwordshow.setImageResource(R.drawable.ic_eye);
            i=1;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setoncicklisteners();


    }
}