package com.example.act4.ui.fragmentpruebafragmento;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.act4.R;

public class FragmentPruebaFragmento extends Fragment {

    private FragmentPruebaFragmentoViewModel mViewModel;

    public static FragmentPruebaFragmento newInstance() {
        return new FragmentPruebaFragmento();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_prueba_fragmento_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentPruebaFragmentoViewModel.class);
        // TODO: Use the ViewModel
    }

}