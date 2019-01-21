package com.example.enaitzdam.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.enaitzdam.retrofittutorial.interfaces.ApiMecAroundInterfaces;
import com.example.enaitzdam.retrofittutorial.responses.Marcas;
import com.example.enaitzdam.retrofittutorial.responses.ResponseAverias;
import com.example.enaitzdam.retrofittutorial.responses.ResponseLogin;
import com.example.enaitzdam.retrofittutorial.responses.ResponseMarcas;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoMarcas extends AppCompatActivity {

    private MarcasAdapter Ma;
    private ListView Mylistview;
//PRUEBA GIT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_marcas);
        Mylistview = findViewById(R.id.listviewaverias);

    }
public  void prueba(){

}
    public void MostrarAverias(View view) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiMecAroundInterfaces apiService = retrofit.create(ApiMecAroundInterfaces.class);

        Call<ResponseMarcas> peticioMarcas = apiService.getMarcas("kkwccowo4c8kosckckc4kwo0gwoosk4048k4ogg4");
        peticioMarcas.enqueue(new Callback<ResponseMarcas>() {

            @Override
            public void onResponse(Call<ResponseMarcas> call, Response<ResponseMarcas> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    List<Marcas> llistatMarcas = response.body().getMarcas();
                    Ma = new MarcasAdapter(ListadoMarcas.this, android.R.layout.simple_spinner_item, llistatMarcas);
                    Mylistview.setAdapter(Ma);
                    Toast.makeText(getApplicationContext(), "Percecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMarcas> call, Throwable t) {
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


