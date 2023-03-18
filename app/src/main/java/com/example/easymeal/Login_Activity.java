package com.example.easymeal;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextPaint;
import android.view.View;
import android.widget.Toast;

import com.example.easymeal.R;
import com.example.easymeal.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity{

    ActivityLoginBinding binding;
    FirebaseAuth auth;

    String phone;
    String password;
    boolean isPasswordVisible;


    private void fieldvalidate(){
        phone = binding.Phone.getText().toString();
        password = binding.Loginpassword.getText().toString();

        if(phone.isEmpty()){
            binding.Phone.setError("Cannot be Empty");
        }else if(password.isEmpty())
                binding.Loginpassword.setError("Cannot be Empty");
        else
            login();

    }

    private void login() {

        phone = binding.Phone.getText().toString();
        password = binding.Loginpassword.getText().toString();
        auth.signInWithEmailAndPassword(phone+"@gmail.com",password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful())
               {
                   startActivity(new Intent(Login_Activity.this,Home.class));
               }else{
                   Toast.makeText(getApplicationContext(),"Wrong Credential",Toast.LENGTH_SHORT).show();
               }
            }
        });

    }


    private  void setoncicklisteners(){
        binding.passwordshow.setOnClickListener(v -> showpass());

        binding.signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldvalidate();
            }
        });


        binding.forgotpass.setOnClickListener(v -> {
            Intent intent = new Intent(Login_Activity.this,SignUp.class);
            intent.putExtra("id","Forgot Password");
            startActivity(intent);
        });

        binding.create.setOnClickListener(view -> {
            Intent intent=new Intent(Login_Activity.this,SignUp.class);
            startActivity(intent);
        });

    }
    private void showpass() {
        if (isPasswordVisible) {
            binding.passwordshow.setImageResource(R.drawable.ic_eye);
            binding.Loginpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            isPasswordVisible = false;
        } else {
            binding.passwordshow.setImageResource(R.drawable.ic_eye_close);
            binding.Loginpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            isPasswordVisible = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(Login_Activity.this,Home.class));
            finish();
        }
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setoncicklisteners();
    }
}

