package com.example.enaitzdam.retrofittutorial.responses;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("email")
    @Expose
    private String email;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseLogin() {
    }

    /**
     *
     * @param nombre
     * @param email
     * @param key
     */
    public ResponseLogin(String key, String nombre, String email) {
        super();
        this.key = key;
        this.nombre = nombre;
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ResponseLogin withKey(String key) {
        this.key = key;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ResponseLogin withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResponseLogin withEmail(String email) {
        this.email = email;
        return this;
    }

}