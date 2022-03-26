package com.example.tema11databases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText code, detail, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        code = (EditText) findViewById(R.id.productCode);
        detail = (EditText) findViewById(R.id.detail);
        price = (EditText) findViewById(R.id.price);

    }

    public void create(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String codigo = code.getText().toString();
        String detalle = detail.getText().toString();
        String precio = price.getText().toString();
        if(!codigo.isEmpty() && !detalle.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo);
            registro.put("detalle", detalle);
            registro.put("precio", precio);
            BaseDatos.insert("articulos", null, registro);
            BaseDatos.close();
            code.setText("");
            detail.setText("");
            price.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Debes llenar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }

    public void read(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getReadableDatabase();
        String codigo = code.getText().toString();
        String detalle = "", precio = "";
        if(!codigo.isEmpty()){
            try{
                // Define a projection that specifies which columns from the databa you will actually use after this query.
                String[] projection = {
                        "detalle",
                        "precio"
                };

                // Filter results WHERE "title" = 'My Title'
                String selection =  "codigo = ?";
                String[] selectionArgs = { codigo };


                Cursor cursor = BaseDatos.query(
                        "articulos",   // The table to query
                        projection,             // The array of columns to return (pass null to get all)
                        selection,              // The columns for the WHERE clause
                        selectionArgs,          // The values for the WHERE clause
                        null,                   // don't group the rows
                        null,                   // don't filter by row groups
                        null               // The sort order
                );
                if(cursor.moveToFirst()){
                    detalle= cursor.getString(0);
                    detail.setText(detalle);
                    BaseDatos.close();
                }else{
                    Toast.makeText(this, "No existe el articulo", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(this, "Toma tu dato", Toast.LENGTH_SHORT).show();
            }catch(Exception e){};

        }else{
            Toast.makeText(this, "Ingresa un codigo valido", Toast.LENGTH_SHORT).show();
        }


    }
}