package com.example.easymeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.easymeal.databinding.ActivityUserDetailBinding;


public class UserDetail extends AppCompatActivity {

    ActivityUserDetailBinding binding;
    String UserName, UserEmail, Password, ConfirmPassword;

    private EditText userdetail_edittext_fullname, userdetail_edittext_email,
            userdetail_edittext_password, userdetail_edittext_confirmpassword;
    private ProgressBar progressBar;


    public void onclicklistener(){
        binding.nextButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FieldValidation();
                if(UserName!=null && UserEmail!=null && Password!=null && ConfirmPassword!=null){
                    //
                }
            }
        });
    }
    // Registration Validation  And Obtain the entered data from the user

    public void FieldValidation() {

        if(binding.userdetailEdittextFullname.getText().toString().isEmpty()){
            binding.userdetailEdittextFullname.setError("cannot be empty");
            userdetail_edittext_fullname.requestFocus();
        }
        else{
            UserName = binding.userdetailEdittextFullname.getText().toString();
        }

        if(binding.userdetailEdittextEmail.getText().toString().isEmpty()){
            binding.userdetailEdittextEmail.setError("cannot be empty");
            userdetail_edittext_email.requestFocus();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher((CharSequence) userdetail_edittext_email).matches()){
            binding.userdetailEdittextEmail.setError("Enter Valid Email Address");
            userdetail_edittext_email.requestFocus();
        }else {
            UserEmail = binding.userdetailEdittextEmail.getText().toString();
        }

        if(binding.userdetailEdittextPassword.getText().toString().isEmpty()){
            binding.userdetailEdittextPassword.setError("cannot be empty");
        }
        // Check if the password meets the criteria
        else if (Password.length() < 8 || !Password.matches(".*[a-zA-Z].*") || !Password.matches(".*\\d.*") || !Password.matches(".*[!@#$%^&*()].*")) {
            // Password doesn't meet criteria, show an error message
            userdetail_edittext_password.setError("Password must be at least 8 characters long and contain at least one alphabet, one special character, and one number");
            userdetail_edittext_password.requestFocus();
        }
        else{
            Password = binding.userdetailEdittextPassword.getText().toString();
        }
        if(binding.userdetailEdittextConfirmpassword.getText().toString().isEmpty()){
            binding.userdetailEdittextConfirmpassword.setError("cannot be empty");
        }
        else if (!Password.equals(ConfirmPassword)) {
            // Passwords don't match, show an error message
            userdetail_edittext_confirmpassword.setError("Passwords do not match");
            userdetail_edittext_confirmpassword.requestFocus();
        } else {
            // Passwords match, proceed with other validation
            ConfirmPassword= binding.userdetailEdittextConfirmpassword.getText().toString();
        }


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
    }
}