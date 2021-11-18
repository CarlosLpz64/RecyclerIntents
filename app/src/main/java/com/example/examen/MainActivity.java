package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.examen.Adaptadores.AdapterOpciones;
import com.example.examen.Modelos.Opcion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RECYCLER
        re=findViewById(R.id.recyclerId);

        //PERMISOS
        String[] PermisosNecesarios = new String[1]; //PERMISOS A SOLICITAR
        PermisosNecesarios[0]= Manifest.permission.CALL_PHONE;
        verificarPermiso(PermisosNecesarios);

        //LISTA
        List<Opcion> l = new ArrayList<>();
        //implicitos
        l.add(new Opcion("MARCAR CONTACTO", new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8713919228"))));
        l.add(new Opcion("ABRIR GOOGLE", new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"))));
        l.add(new Opcion("ABRIR MAPA", new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749,-122.4192?q=" + Uri.encode("1st & Pike, Seattle")))));
        l.add(new Opcion("DIALER", new Intent(Intent.ACTION_VIEW,Uri.parse("tel:8713919228"))));
        //explicito
        l.add(new Opcion("CAMBIAR DE ACTIVITY", new Intent(MainActivity.this, IntentExplicito.class) ));


        AdapterOpciones Ad = new AdapterOpciones(l);
        re.setAdapter(Ad);
        re.setHasFixedSize(true);
       // LinearLayoutManager lr = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager lr = new LinearLayoutManager(this);
        re.setLayoutManager(lr);
        verificarPermiso(PermisosNecesarios);

        Ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentImp;
                IntentImp = l.get(re.getChildAdapterPosition(v)).getAccion();
                startActivity(IntentImp);
            }
        });
    }

    private void verificarPermiso(String[] permisosNecesarios) {
        String[] PermisosDenegados = new String[1]; //PERMISOS DENEGADOS
        for(int i=0; i<permisosNecesarios.length; i++){
            if (ContextCompat.checkSelfPermission(this, permisosNecesarios[i]) == PackageManager.PERMISSION_DENIED){
                PermisosDenegados[i]=permisosNecesarios[i]; //AGREGAR A LISTA LOS NO PERMITIDOS
            }
        }
        requestPermissions(PermisosDenegados,300); //SOLICITA LOS PERMISOS NECESARIOS
    }

    //VENTANA PARA SOLICITAR PERMISO
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (requestCode){
            case 300:
                if (permissions.length>0){
                    if(grantResults[0]==PackageManager.PERMISSION_GRANTED){ //AQUÍ HABRÍA UN FOR QUE RECORRA LOS PERMISOS
                        //REANUDAR ACCION PREVIA (OPCIONAL)
                    } else {
                        if(ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])){ //SE EJECUTA SI ES LA SEGUNDA VEZ QUE SE PREGUNTA
                            //ACCIÓN OPCIONAL
                        }
                    }
                }
                break;

        }
    }
}