package com.example.tabsapplication.ui.notifications;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tabsapplication.AdminSQLiteOpenHelper;
import com.example.tabsapplication.R;
import com.example.tabsapplication.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;
    private EditText name;
    private Button addActividad;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        name = (EditText) getView().findViewById(R.id.actividadName2);
        addActividad = (Button) getView().findViewById(R.id.addActividad);
        addActividad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    add(view);
                }
            }

        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void add(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getView().getContext(), "Registros", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String nombre = name.getText().toString();
        if(!nombre.isEmpty() ){
            try {
                ContentValues registro = new ContentValues();

                registro.put("actividad", nombre);
                BaseDatos.insert("pomo", null, registro);
                BaseDatos.close();
                name.setText("");

                Toast.makeText(getView().getContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(getView().getContext(), e.toString(), Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(getView().getContext(), "Debes llenar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }
}