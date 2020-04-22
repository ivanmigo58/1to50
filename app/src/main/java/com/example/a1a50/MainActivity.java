package com.example.a1a50;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static Random random;
    static Chronometer cronometroJuego;


    static boolean[] asignados = new boolean[50];

    static int actual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity instance = this;

        random = new Random();

        cronometroJuego = findViewById(R.id.cronometrojuego);

        Botones.botones = new Button[25];

        for (int i = 0; i < 25; i++) {
            Botones.botones[i] = findViewById(getResources().getIdentifier("boton" + i, "id", getPackageName()));
        }

        initGame();
    }

    static void initGame() {
        actual = 1;

        for (int i = 0; i < 50; i++) {
            asignados[i] = false;
        }

        // Ponemos los 25 botones visibles
        Game.buttonsVisibles();
        // Mostramos los 25 primeros botones con un numero random
        Game.initFirst25Buttons();

        cronometroJuego.setBase(SystemClock.elapsedRealtime());

    }

    public void clicBoton(final View view){
        Button boton = (Button) view;

        if (boton.getText().toString().equals(String.valueOf(actual))){

            if (actual == 1){
                cronometroJuego.setBase(SystemClock.elapsedRealtime());
                cronometroJuego.start();
            }

            if (actual == 50){
                cronometroJuego.stop();
                new AlertDialog.Builder(this)
                        .setTitle("COMPLETADO!")
                        .setMessage("Tiempo: " + cronometroJuego.getContentDescription())
                        .setPositiveButton("Jugar de nuevo", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.initGame();
                            }
                        })
                        .create()
                        .show();

            } else if (actual <= 25) {
                Game.lessThan25(boton);
            } else {
                boton.setVisibility(View.INVISIBLE);
            }
            actual++;
        }
    }
}
