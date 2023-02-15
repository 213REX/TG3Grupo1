package com.example.tg3grupo1.Vistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tg3grupo1.BBDD.ModeloAdo;
import com.example.tg3grupo1.Fragments.ContenidoGeneral;
import com.example.tg3grupo1.Modelo.Modelo;
import com.example.tg3grupo1.R;

import java.util.ArrayList;
import java.util.List;

public class AlertDialogs {
    private static AlertDialog dialogProgress;

    public static void AlertError(Context context, String contenido) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.alert_dialog_alertas, null);
        TextView textView = view.findViewById(R.id.txtError);
        textView.setText(contenido);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public static void AlertProgres(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.alert_dialog_progres_bar, null);
        builder.setView(view);
        dialogProgress = builder.create();
        dialogProgress.setCanceledOnTouchOutside(false);
        dialogProgress.show();
    }

    public static void AlertProgressCerrar() {
        dialogProgress.dismiss();
    }

    public static void AlertBusquedas(Context context) {
//        ModeloAdo modeloAdo = new ModeloAdo(context);
//        final List<Modelo>[] contenido = new ArrayList[]{new ArrayList<>()};
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.alert_dialog_busquedas, null);
//        ImageButton imageButton = view.findViewById(R.id.btnBuscar);
//        EditText campobuscar = view.findViewById(R.id.campoBuscar);
//        builder.setView(view);
//        AlertDialog dialogBusquedas = builder.create();
//        ArrayList<Modelo> contenidoBusqueda;
//        imageButton.setOnClickListener(v -> {
//            if (campobuscar.getText().toString().isEmpty()) {
//                campobuscar.setError("No puede quedar vacio");
//            } else {
//                contenido[0] = modeloAdo.buscar(campobuscar.getText().toString());
//                contenidoBusqueda = (ArrayList<Modelo>) contenido[0];
//                if (contenidoBusqueda.size() !=0){
//                    Inicio inicio = new Inicio();
//                    inicio.busquedas();
//                }
//            }
//        });
//        dialogBusquedas.show();
    }

//    public static void AlertBusquedasCerrar() {
//        dialogBusquedas.dismiss();
//    }
}
