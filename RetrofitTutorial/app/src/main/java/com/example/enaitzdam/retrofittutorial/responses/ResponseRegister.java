package com.example.enaitzdam.retrofittutorial.responses;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseRegister {



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
        public ResponseRegister() {
        }

        /**
         *
         * @param nombre
         * @param email
         * @param key
         */
        public ResponseRegister(String key, String nombre, String email) {
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

        public ResponseRegister withKey(String key) {
            this.key = key;
            return this;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public ResponseRegister withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public ResponseRegister withEmail(String email) {
            this.email = email;
            return this;
        }

    }


