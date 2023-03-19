package com.example.easymeal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.easymeal.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ActivityHomeBinding binding;


    Profile profileFragment;

    BottomNavigationView navigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);


        navigationView = findViewById(R.id.bottomnavigationview);
        getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new Discover()).commit();


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.discoverhome:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new Discover()).commit();

                        break;
                    }

                    case R.id.addtocart:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new Cart()).commit();
                        break;
                    }

                    case R.id.profile:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new Profile()).commit();
                        break;
                    }
                }
                return false;
            }
        });

    }
}