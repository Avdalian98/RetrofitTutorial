package com.example.enaitzdam.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
public void prueba2(){

    }
    public void ClickMarques(View view) {
        Intent intent = new Intent(getApplicationContext(), ListadoMarcas.class);
        startActivity(intent);
    }

    public void ClickTallers(View view) {
        Intent intent = new Intent(getApplicationContext(), ListadoTalleres.class);
        startActivity(intent);
    }

    public void ClickAveries(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterAverias.class);
        startActivity(intent);
    }

    public void ClickListaAveries(View view) {
        Intent intent = new Intent(getApplicationContext(), ListadoAverias.class);
        startActivity(intent);
    }
}
