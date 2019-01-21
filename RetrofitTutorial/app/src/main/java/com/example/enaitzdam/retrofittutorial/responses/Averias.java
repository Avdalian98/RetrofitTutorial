package com.example.enaitzdam.retrofittutorial.responses;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Averias {


        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("marca_id")
        @Expose
        private String marcaId;
        @SerializedName("modelo")
        @Expose
        private String modelo;
        @SerializedName("titulo")
        @Expose
        private String titulo;
        @SerializedName("descripcion")
        @Expose
        private String descripcion;

        /**
         * No args constructor for use in serialization
         *
         */
        public Averias() {
        }

        /**
         *
         * @param id
         * @param titulo
         * @param userId
         * @param descripcion
         * @param modelo
         * @param marcaId
         */
        public Averias(String id, String userId, String marcaId, String modelo, String titulo, String descripcion) {
            super();
            this.id = id;
            this.userId = userId;
            this.marcaId = marcaId;
            this.modelo = modelo;
            this.titulo = titulo;
            this.descripcion = descripcion;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Averias withId(String id) {
            this.id = id;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Averias withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getMarcaId() {
            return marcaId;
        }

        public void setMarcaId(String marcaId) {
            this.marcaId = marcaId;
        }

        public Averias withMarcaId(String marcaId) {
            this.marcaId = marcaId;
            return this;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public Averias withModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public Averias withTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Averias withDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

    }

