package com.example.act4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction transaction;
    FragmentPrueba fragmentPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentPrueba = new FragmentPrueba();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragmentPrueba).commit();
    }
}