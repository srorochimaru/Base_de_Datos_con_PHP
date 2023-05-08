package net.lrivas.miagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModificarContacto extends AppCompatActivity {

    //ConexionSQLite objConexion;
    //final String NOMBRE_BASE_DATOS = "miagenda";
    EditText nombre, telefono;
    Button botonAgregar, botonRegresar, botonEliminar;
    int id_contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_contacto);

        //objConexion = new ConexionSQLite(ModificarContacto.this, NOMBRE_BASE_DATOS,null,1);
        nombre = findViewById(R.id.txtNombreCompletoEditar);
        telefono = findViewById(R.id.txtTelefonoEditar);

        botonAgregar = findViewById(R.id.btnGuardarContactoEditar);
        botonRegresar = findViewById(R.id.btnRegresarEditar);
        botonEliminar = findViewById(R.id.btnEliminarEditar);

        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modificar();
            }
        });

        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresar();
            }
        });

        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();
            }
        });
    }

    private void modificar(){
        /*try{
            SQLiteDatabase miBaseDatos = objConexion.getWritableDatabase();
            String comando = "UPDATE contactos SET nombre='"+ nombre.getText() +"',telefono='"+ telefono.getText() +"' " +
                    "WHERE id_contacto='"+id_contacto+"'";
            miBaseDatos.execSQL(comando);
            miBaseDatos.close();
            Toast.makeText(ModificarContacto.this, "Datos Modificados con exito", Toast.LENGTH_LONG).show();
        }catch (Exception error){
            Toast.makeText(ModificarContacto.this, "Error: "+ error.getMessage(), Toast.LENGTH_LONG).show();
        }*/
    }

    private void regresar(){
        Intent actividad = new Intent(ModificarContacto.this, MainActivity.class);
        startActivity(actividad);
        ModificarContacto.this.finish();
    }

    private void eliminar(){
        /*try{
            SQLiteDatabase miBaseDatos = objConexion.getWritableDatabase();
            String comando = "DELETE FROM contactos WHERE id_contacto='"+id_contacto+"'";
            miBaseDatos.execSQL(comando);
            miBaseDatos.close();
            Toast.makeText(ModificarContacto.this, "Datos Eliminados con exito", Toast.LENGTH_LONG).show();
        }catch (Exception error){
            Toast.makeText(ModificarContacto.this, "Error: "+ error.getMessage(), Toast.LENGTH_LONG).show();
        }*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle valoresAdicionales = getIntent().getExtras();
        if(valoresAdicionales==null){
            Toast.makeText(ModificarContacto.this, "Debe enviar un ID de contacto", Toast.LENGTH_SHORT).show();
            id_contacto = 0;
            regresar();
        }else{
            id_contacto = valoresAdicionales.getInt("id_contacto");
            verContacto();
        }
    }

    private void verContacto(){
        /*SQLiteDatabase base = objConexion.getReadableDatabase();
        String consulta = "select id_contacto,nombre,telefono from contactos WHERE id_contacto='"+ id_contacto +"'";
        Cursor cadaRegistro = base.rawQuery(consulta,null);
        if(cadaRegistro.moveToFirst()){
            do{
                nombre.setText(cadaRegistro.getString(1));
                telefono.setText(cadaRegistro.getString(2));
            }while(cadaRegistro.moveToNext());
        }*/
    }
}
