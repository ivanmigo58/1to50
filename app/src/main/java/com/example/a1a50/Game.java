package com.example.a1a50;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

public class Game {
    static void buttonsVisibles() {
        // Visibilidad en todos los botones
        for (int i = 0; i < 25; i++) {
            Botones.botones[i].setVisibility(Botones.botones[i].VISIBLE);
        }
    }

    // Iniciamos los primeros 25 botones
    static void initFirst25Buttons() {
        for (int i = 0; i < 25; i++) {
            while (true) {
                int num = MainActivity.random.nextInt(25);

                if (!MainActivity.asignados[num]) {
                    Botones.botones[i].setText(String.valueOf(num+1));
                    Botones.botones[i].setBackgroundColor(Color.parseColor("#4466aa"));
                    MainActivity.asignados[num] = true;
                    break;
                }
            }
        }
    }

    // Cuando el numero que se ha clickado es menor o igual que 25
    static void lessThan25(Button boton) {
        while (true) {
            int num = MainActivity.random.nextInt(50);

            if (!MainActivity.asignados[num]) {
                boton.setText(String.valueOf(num+1));
                boton.setBackgroundColor(Color.parseColor("#335599"));
                MainActivity.asignados[num] = true;
                break;
            }
        }
    }

}
