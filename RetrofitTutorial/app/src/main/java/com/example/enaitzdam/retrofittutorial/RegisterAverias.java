package com.example.enaitzdam.retrofittutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enaitzdam.retrofittutorial.interfaces.ApiMecAroundInterfaces;
import com.example.enaitzdam.retrofittutorial.responses.ResponseRegister;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterAverias extends AppCompatActivity {
    EditText editTextMail,editTextPassword ,EditTextNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//X-API-KEY, titulo, descripcion, marca, modelo

        editTextMail = findViewById(R.id.textView_email_register);
        editTextPassword=findViewById(R.id.textView_password_register);
        EditTextNombre= findViewById(R.id.textView_nombre_register);
    }

    public void Register_R(View view) {
        String nombre = EditTextNombre.getText().toString();
        String email = editTextMail.getText().toString();
        String pass = editTextPassword.getText().toString();

        if (!email.isEmpty() && !pass.isEmpty() && !nombre.isEmpty()) {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getString(R.string.API_baseurl))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiMecAroundInterfaces apiService = retrofit.create(ApiMecAroundInterfaces.class);

            Call<ResponseRegister> peticioRegister = apiService.doRegister(nombre,pass,email);


            //3
            peticioRegister.enqueue(new Callback<ResponseRegister>() {
                //Si la connexió no s'ha perdut i la comunicació ha estat correcte.
                //Entra a l'onResponse encara que torni un codi de no haver trobat res.

                @Override
                public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                    if (response.code()== HttpURLConnection.HTTP_OK){

                        //Si volem obtenir parametres de la crida a l'API:
                        // String nomUser = response.body().getNombre();
                        String key = response.body().getKey();
                        Toast.makeText(getApplicationContext(), "Register OK  "+key, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
                // Si peta la connexió a Internet.
                @Override
                public void onFailure(Call<ResponseRegister> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
                }
            });





        }
        else{

            Toast.makeText(this, "Login KO", Toast.LENGTH_SHORT).show();
        }
    }
}

