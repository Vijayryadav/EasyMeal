package com.example.easymeal;


import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import static com.google.common.util.concurrent.Futures.submit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.easymeal.databinding.ActivityUserDetailBinding;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserDetail extends AppCompatActivity {

    ActivityUserDetailBinding binding;
    String UserName, UserEmail, password;

    public static final String TAG = "TAG";

    ProgressBar progressBar;
    CheckBox mcheckbox;
    public  static  long points;
    long pointss  = 1000;
    String user;


    FirebaseFirestore fstore;
    String userID;
    FirebaseAuth fAuth;
    FirebaseFirestore db;




    public void FieldValidation() {

        if(binding.FullName.getText().toString().isEmpty()){
            binding.FullName.setError("cannot be empty");
            binding.FullName.requestFocus();
        }

        else if(binding.Email.getText().toString().isEmpty()){
            binding.Email.setError("cannot be empty");
            binding.Email.requestFocus();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher((CharSequence) binding.Email.getText().toString()).matches()){
            binding.Email.setError("Enter Valid Email Address");
            binding.Email.requestFocus();
        }
        else if(binding.Password.getText().toString().isEmpty()){
            binding.Password.setError("cannot be empty");
            binding.Password.requestFocus();
        }
        // Check if the password meets the criteria
        else if (binding.Password.getText().toString().length() < 8 || !binding.Password.getText().toString().matches(".*[a-zA-Z].*") || !binding.Password.getText().toString().matches(".*\\d.*") || !binding.Password.getText().toString().matches(".*[!@#$%^&*()].*")) {
            // Password doesn't meet criteria, show an error message
            binding.Password.setError("Password must be at least 8 characters long and contain at least one alphabet, one special character, and one number");
            binding.Password.requestFocus();
        } else if (binding.House.getText().toString().isEmpty()) {
            binding.House.setError("Can not Empty");
            binding.House.requestFocus();


        } else if (binding.Area.getText().toString().isEmpty()) {
            binding.Area.setError("Can not Empty");
            binding.Area.requestFocus();
        } else if (binding.City.getText().toString().isEmpty()) {
            binding.City.setError("can not empty");
            binding.City.requestFocus();

        }
        else if (binding.State.getText().toString().isEmpty()) {
            binding.State.setError("can not empty");
            binding.State.requestFocus();
        }

        else if (binding.Pincode.getText().toString().isEmpty()) {
            binding.Pincode.setError("can not empty");
            binding.Pincode.requestFocus();
        }
        else {
            registerUser();



        }


    }

    private void registerUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("username", binding.FullName.getText().toString());
        user.put("phone", getIntent().getStringExtra("Phone Number"));
        user.put("password", binding.Password.getText().toString());
        user.put("house",binding.House.getText().toString());
        user.put("area",binding.Area.getText().toString());
        user.put("City",binding.City.getText().toString());
        user.put("State", binding.State.getText().toString());
        user.put("Pincode", binding.Pincode.getText().toString());



        // binding mobile number as email id
        AuthCredential credential = EmailAuthProvider.getCredential(getIntent().getStringExtra("Phone Number")+"@gmail.com",binding.Password.getText().toString());
        FirebaseAuth.getInstance().getCurrentUser()
                .linkWithCredential(credential)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(getApplicationContext(),"Credential Linked",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("Linkinf","Failed");
                    }
                });
        db.collection("users").document(FirebaseAuth.getInstance().getUid())
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(UserDetail.this, "User saved successfully", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(UserDetail.this, Home.class);
                        startActivity(intent);
                        finish();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UserDetail.this, "Error saving user: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


         db = FirebaseFirestore.getInstance();

        binding.Register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                FieldValidation();

            }


        });

    }






}

