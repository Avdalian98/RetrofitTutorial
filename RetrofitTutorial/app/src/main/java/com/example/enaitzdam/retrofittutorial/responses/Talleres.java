package com.example.enaitzdam.retrofittutorial.responses;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Talleres {


        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("nombre")
        @Expose
        private String nombre;
        @SerializedName("latlng")
        @Expose
        private String latlng;
        @SerializedName("direccion")
        @Expose
        private String direccion;
        @SerializedName("telefono")
        @Expose
        private String telefono;

        /**
         * No args constructor for use in serialization
         *
         */
        public Talleres() {
        }

        /**
         *
         * @param nombre
         * @param id
         * @param direccion
         * @param telefono
         * @param latlng
         */
        public Talleres(String id, String nombre, String latlng, String direccion, String telefono) {
            super();
            this.id = id;
            this.nombre = nombre;
            this.latlng = latlng;
            this.direccion = direccion;
            this.telefono = telefono;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Talleres withId(String id) {
            this.id = id;
            return this;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Talleres withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public String getLatlng() {
            return latlng;
        }

        public void setLatlng(String latlng) {
            this.latlng = latlng;
        }

        public Talleres withLatlng(String latlng) {
            this.latlng = latlng;
            return this;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public Talleres withDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public Talleres withTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

    }

