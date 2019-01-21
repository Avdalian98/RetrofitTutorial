package com.example.enaitzdam.retrofittutorial;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.enaitzdam.retrofittutorial.interfaces.ApiMecAroundInterfaces;
import com.example.enaitzdam.retrofittutorial.responses.ResponseTalleres;
import com.example.enaitzdam.retrofittutorial.responses.Talleres;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.enaitzdam.retrofittutorial.MainActivity.PUBLIC_KEY;

public class ListadoTalleres extends AppCompatActivity {


    private TallerAdapter Ta;
    private ListView Mylistview;

    //PRUEBA GIT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_talleres);
        Mylistview = findViewById(R.id.listviewtalleres);
        SharedPreferences prefs = getSharedPreferences(PUBLIC_KEY, MODE_PRIVATE);
        final String restoredText = prefs.getString("KEY", "Not Found");
        Toast.makeText(getApplicationContext(),restoredText , Toast.LENGTH_SHORT).show();
    }

    public void MostrarTalleres(View view) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiMecAroundInterfaces apiService = retrofit.create(ApiMecAroundInterfaces.class);
        SharedPreferences prefs = getSharedPreferences(PUBLIC_KEY, MODE_PRIVATE);
        final String restoredText = prefs.getString("KEY", "Not Found");
        Toast.makeText(getApplicationContext(),restoredText , Toast.LENGTH_SHORT).show();
        Call<ResponseTalleres> peticioTalleres = apiService.getTalleres(restoredText);
        peticioTalleres.enqueue(new Callback<ResponseTalleres>() {

            @Override
            public void onResponse(Call<ResponseTalleres> call, Response<ResponseTalleres> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    List<Talleres> llistattalleres = response.body().getTalleres();
                    Ta = new TallerAdapter(ListadoTalleres.this, android.R.layout.simple_spinner_item, llistattalleres);
                    Mylistview.setAdapter(Ta);
                    Toast.makeText(getApplicationContext(), "Percecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseTalleres> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
            }
        });
    }


}




/*

        //3
        PeticionMarcas.enqueue(new Callback<ResponseMarcas>() {
                                   //Si la connexió no s'ha perdut i la comunicació ha estat correcte.
                                   //Entra a l'onResponse encara que torni un codi de no haver trobat res.

                                   @Override
                                   public void onResponse(Call<ResponseMarcas> call, Response<ResponseMarcas> response) {
                                       if (response.code() == HttpURLConnection.HTTP_OK) {

                                           List<Marcas> llistatMarcas = response.body().getMarcas();
                                           Ma = new MarcasAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, llistatMarcas);
                                           Mylistview.setAdapter(Ma);
                                           Toast.makeText(getApplicationContext(), "Percecto", Toast.LENGTH_SHORT).show();

                                       }
                                   }
                                   @Override
                                   public void onFailure(Call<ResponseMarcas> call, Throwable t) {
                                       Toast.makeText(getApplicationContext(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
                                   }
        });
*/

