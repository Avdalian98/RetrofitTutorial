package com.example.enaitzdam.retrofittutorial.responses;


        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class ResponseMarcas {

    @SerializedName("marcas")
    @Expose
    private List<Marcas> marcas = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseMarcas() {
    }

    /**
     *
     * @param marcas
     */
    public ResponseMarcas(List<Marcas> marcas) {
        super();
        this.marcas = marcas;
    }

    public List<Marcas> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marcas> marcas) {
        this.marcas = marcas;
    }

    public ResponseMarcas withMarcas(List<Marcas> marcas) {
        this.marcas = marcas;
        return this;
    }

}