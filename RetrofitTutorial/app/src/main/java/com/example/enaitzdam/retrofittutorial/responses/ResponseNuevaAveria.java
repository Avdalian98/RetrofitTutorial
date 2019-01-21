package com.example.enaitzdam.retrofittutorial.responses;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseNuevaAveria {


        @SerializedName("mensaje")
        @Expose
        private String mensaje;
        @SerializedName("id")
        @Expose
        private String id;

        /**
         * No args constructor for use in serialization
         *
         */
        public ResponseNuevaAveria() {
        }

        /**
         *
         * @param id
         * @param mensaje
         */
        public ResponseNuevaAveria(String mensaje, String id) {
            super();
            this.mensaje = mensaje;
            this.id = id;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public ResponseNuevaAveria withMensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public ResponseNuevaAveria withId(String id) {
            this.id = id;
            return this;
        }

    }



