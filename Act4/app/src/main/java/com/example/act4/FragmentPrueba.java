package com.example.act4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.act4.ui.fragmentpruebafragmento.FragmentPruebaFragmento;

public class FragmentPrueba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_prueba_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerPreuba, FragmentPruebaFragmento.newInstance())
                    .commitNow();
        }
    }
}