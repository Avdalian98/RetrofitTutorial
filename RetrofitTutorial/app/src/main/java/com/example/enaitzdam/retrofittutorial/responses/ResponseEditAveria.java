package com.example.enaitzdam.retrofittutorial.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseEditAveria {

    @SerializedName("mensaje")
    @Expose
    private String mensaje;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseEditAveria() {
    }

    /**
     *
     * @param mensaje
     */
    public ResponseEditAveria(String mensaje) {
        super();
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ResponseEditAveria withMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

}