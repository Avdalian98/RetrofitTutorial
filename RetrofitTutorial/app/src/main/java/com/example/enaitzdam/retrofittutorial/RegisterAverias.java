package com.example.enaitzdam.retrofittutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enaitzdam.retrofittutorial.interfaces.ApiMecAroundInterfaces;
import com.example.enaitzdam.retrofittutorial.responses.ResponseAverias;
import com.example.enaitzdam.retrofittutorial.responses.ResponseRegister;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.enaitzdam.retrofittutorial.MainActivity.PUBLIC_KEY;

public class RegisterAverias extends AppCompatActivity {
    EditText editTexttTIULO,editTextDESCRIPCION ,EditTextMARCA,EditTextModelo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_averias);
//X-API-KEY, titulo, descripcion, marca, modelo

        editTexttTIULO = findViewById(R.id.titulo_et);
        editTextDESCRIPCION=findViewById(R.id.descripcion_et);
        EditTextMARCA= findViewById(R.id.marca_et);
        EditTextModelo= findViewById(R.id.modelo_et);
    }

    public void Register_R(View view) {
        String titulo = editTexttTIULO.getText().toString();
        String descripcion = editTextDESCRIPCION.getText().toString();
        String marca = EditTextMARCA.getText().toString();
        String modelo = EditTextModelo.getText().toString();

        if (!titulo.isEmpty() && !descripcion.isEmpty() && !marca.isEmpty()&& !modelo.isEmpty()) {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getString(R.string.API_baseurl))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiMecAroundInterfaces apiService = retrofit.create(ApiMecAroundInterfaces.class);
            SharedPreferences prefs = getSharedPreferences(PUBLIC_KEY, MODE_PRIVATE);
            final String restoredText = prefs.getString("KEY", "Not Found");
            Toast.makeText(getApplicationContext(), restoredText, Toast.LENGTH_SHORT).show();
            Call<ResponseAverias> peticioRegister = apiService.doRegisterAveria(restoredText,titulo,descripcion,marca,modelo);


            //3
            peticioRegister.enqueue(new Callback<ResponseAverias>() {
                //Si la connexió no s'ha perdut i la comunicació ha estat correcte.
                //Entra a l'onResponse encara que torni un codi de no haver trobat res.

                @Override
                public void onResponse(Call<ResponseAverias> call, Response<ResponseAverias> response) {
                    if (response.code()== HttpURLConnection.HTTP_OK){

                        //Si volem obtenir parametres de la crida a l'API:
                        // String nomUser = response.body().getNombre();

                        Toast.makeText(getApplicationContext(), "Register OK  ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(intent);
                    }
                }
                // Si peta la connexió a Internet.
                @Override
                public void onFailure(Call<ResponseAverias> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
                }
            });





        }
        else{

            Toast.makeText(this, "Login KO", Toast.LENGTH_SHORT).show();
        }
    }

    public void RegistreAverias(View view) {
        Intent intent = new Intent(getApplicationContext(), ListadoAverias.class);
        startActivity(intent);
    }
}

