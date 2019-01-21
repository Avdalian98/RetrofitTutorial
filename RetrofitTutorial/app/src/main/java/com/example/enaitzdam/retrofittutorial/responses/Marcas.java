package com.example.enaitzdam.retrofittutorial.responses;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Marcas {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("marca")
    @Expose
    private String marca;

    /**
     * No args constructor for use in serialization
     *
     */
    public Marcas() {
    }

    /**
     *
     * @param id
     * @param marca
     */
    public Marcas(String id, String marca) {
        super();
        this.id = id;
        this.marca = marca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Marcas withId(String id) {
        this.id = id;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Marcas withMarca(String marca) {
        this.marca = marca;
        return this;
    }

}