package com.example.easymeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        RecyclerView list = findViewById(R.id.recycler_view);

        TiffinCenter[] projects ={
                new TiffinCenter("Shudh Tiffin Center","Housing Board","Pricing starts from Rs50", R.drawable.tiffincenter),
                new TiffinCenter("Sunny's Kitchen","Adarsh Nagar","Pricing starts from Rs70", R.drawable.tiffincenter),
                new TiffinCenter("Mahakal Tiffin Center","Bhawani dham", "Pricing starts Rs50", R.drawable.ic_launcher_background),
                new TiffinCenter("Braj Bhojnalaya","Kiran Nagar", "Pricing starts Rs50", R.drawable.ic_launcher_background),
                new TiffinCenter("Raj darbar","GandhiNagar", "Pricing starts from Rs50", R.drawable.ic_launcher_background)

        };

        TiffinCenterAdapter adapter= new TiffinCenterAdapter(projects);
        list.setAdapter(adapter);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    Intent menuHomeIntent= new Intent();

                    return true;
                case R.id.menu_setting:
                    // switch to search fragment/activity
                    return true;
                case R.id.menu_cart:
                    // switch to profile fragment/activity
                    return true;
                default:
                    return false;
            }
        });

    }
}