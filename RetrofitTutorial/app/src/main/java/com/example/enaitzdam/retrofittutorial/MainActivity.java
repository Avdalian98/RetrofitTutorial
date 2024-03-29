package com.example.enaitzdam.retrofittutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enaitzdam.retrofittutorial.interfaces.ApiMecAroundInterfaces;
import com.example.enaitzdam.retrofittutorial.responses.ResponseLogin;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String PUBLIC_KEY ="" ;
    EditText editTextMail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMail = findViewById(R.id.editTextMail);
        editTextPassword = findViewById(R.id.editTextPassword);


    }

    public void doLogin(View view) {

        String email = editTextMail.getText().toString();
        String pass = editTextPassword.getText().toString();

        if (!email.isEmpty() && !pass.isEmpty()) {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getString(R.string.API_baseurl))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiMecAroundInterfaces apiService = retrofit.create(ApiMecAroundInterfaces.class);

            Call<ResponseLogin> peticioLogin = apiService.doLogin(email, pass);


            //3
            peticioLogin.enqueue(new Callback<ResponseLogin>() {

                //Si la connexió no s'ha perdut i la comunicació ha estat correcte.
                //Entra a l'onResponse encara que torni un codi de no haver trobat res.

                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    if (response.code()==HttpURLConnection.HTTP_OK){

                        //Si volem obtenir parametres de la crida a l'API:
                        String nomUser = response.body().getNombre();
                        SharedPreferences.Editor editor = getSharedPreferences(PUBLIC_KEY, MODE_PRIVATE).edit();
                        String a = response.body().getKey();
                        editor.putString("KEY", a);
                        editor.apply();
                        Toast.makeText(MainActivity.this, "Login OK "+nomUser, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(intent);
                    }
                }
                // Si peta la connexió a Internet.
                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
                }
            });





        }
        else{

            Toast.makeText(this, "Login KO", Toast.LENGTH_SHORT).show();
        }
    }

    public void Register(View view) {
        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);
    }
}
