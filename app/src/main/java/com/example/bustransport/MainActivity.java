package com.example.bustransport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView BottomNavigationView;
    ImageView ProfileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        onClick();
    }

    private void initialize() {

        ProfileImageView = (ImageView)findViewById(R.id.ProfileImageView);

        BottomNavigationView = (BottomNavigationView)findViewById(R.id.BottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment,new BusNumberFragment()).commit();
        return;
    }

    private void onClick() {

        ProfileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this ,Profile.class);
                startActivity(intent);
            }
        });

        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;

                 switch (menuItem.getItemId()){
                     case R.id.BusNo:
                         selectedFragment = new BusNumberFragment();
                         break;
                     case R.id.Timings:
                         selectedFragment = new TimingsFragment();
                         break;
                     case R.id.Route:
                         selectedFragment = new RouteFragment();
                         break;
                     case R.id.Stage:
                         selectedFragment = new StageFragment();
                         break;
                 }

                 getSupportFragmentManager().beginTransaction().replace(R.id.Fragment,selectedFragment).commit();
                return true;
            }
        });
    }
}
