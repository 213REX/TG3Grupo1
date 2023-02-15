package com.example.tg3grupo1.Vistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.tg3grupo1.R;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.alert_dialog_busquedas, null);
//        ImageButton imageButton = view.findViewById(R.id.imageView6);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
