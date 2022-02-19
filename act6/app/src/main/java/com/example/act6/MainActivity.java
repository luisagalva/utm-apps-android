package com.example.act6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private TextView nacimiento, edad, consulta;
    private EditText dateInput;
    private String selectedDate = "";
    private Calendar nacimientoDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
         nacimiento = (TextView)findViewById(R.id.nacimiento);
         edad = (TextView)findViewById(R.id.edad);
         consulta = (TextView)findViewById(R.id.consulta);
         dateInput = (EditText)findViewById(R.id.dateInput);
        dateInput.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                DialogFragment datePickerDialog = new TimePickerFragment();
                datePickerDialog.show(getSupportFragmentManager(), "date-picker");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar consultaDate = Calendar.getInstance();
                consulta.setText(DateFormat.getDateInstance(DateFormat.FULL).format(consultaDate.getTime()).toString());
                nacimiento.setText(selectedDate);
                Integer edadint = consultaDate.get(Calendar.YEAR) - nacimientoDate.get((Calendar.YEAR));

                edad.setText(edadint.toString());
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        nacimientoDate = Calendar.getInstance();
        // Set static variables of Calendar instance
        nacimientoDate.set(Calendar.YEAR,year);
        nacimientoDate.set(Calendar.MONTH,month);
        nacimientoDate.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        // Get the date in form of string

        selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(nacimientoDate.getTime());

        // Set the textview to the selectedDate String

        dateInput.setText(selectedDate);
    }

}