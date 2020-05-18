package com.example.tutoria_usco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tutoria_usco.model.Persona;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText nomP, telP, diasP, asigP;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomP = findViewById(R.id.txt_nombrePersona);
        telP = findViewById(R.id.txt_telefonoPersona);
        diasP = findViewById(R.id.txt_diasPersona);
        asigP = findViewById(R.id.txt_AsigntauraPersona);

        inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String nombre = nomP.getText().toString();
        String telefono = telP.getText().toString();
        String dias = diasP.getText().toString();
        String asignatura = asigP.getText().toString();
        switch (item.getItemId()){
            case R.id.icon_add:{
                Toast.makeText(this,"Agregar", Toast.LENGTH_LONG).show();
                if(nombre.equals("")||telefono.equals("")||dias.equals("")||asignatura.equals("") ){
                    validacion();
                }
                else {
                    Persona p = new Persona();
                    p.setUid(UUID.randomUUID().toString());
                    p.setNombre(nombre);
                    p.setTelefono(telefono);
                    p.setDias(dias);
                    p.setAsignatura(asignatura);
                    databaseReference.child("Persona").child(p.getUid()).setValue(p);

                    Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
                    limpiarcajas();
                }
                break;
            }
            case R.id.icon_save:{
                Toast.makeText(this, "Tutores Disponibles", Toast.LENGTH_SHORT).show();
                Intent int1=new Intent(this,horario.class);
                startActivity(int1);
                break;
            }
            case R.id.icon_home:{
                Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show();
                Intent int1=new Intent(this,publicar.class);
                startActivity(int1);
                break;
            }
            default:break;
        }
        return true;
    }

    private void limpiarcajas() {
        nomP.setText("");
        telP.setText("");
        diasP.setText("");
    }

    private void validacion() {
        String nombre = nomP.getText().toString();
        String telefono = telP.getText().toString();
        String dias = diasP.getText().toString();
        String asignatura = asigP.getText().toString();
        if(nombre.equals("")){
            nomP.setError("Requerido");
        }
        else if(telefono.equals("")){
            telP.setError("Requerido");
        }
        else if (dias.equals("")){
            diasP.setError("Requerido");
        }
        else if (asignatura.equals("")){
            diasP.setError("Requerido");
        }
    }
}
