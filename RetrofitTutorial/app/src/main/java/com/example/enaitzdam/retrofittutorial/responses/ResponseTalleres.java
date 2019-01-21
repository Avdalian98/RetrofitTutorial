package com.example.enaitzdam.retrofittutorial.responses;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseTalleres {


        @SerializedName("talleres")
        @Expose
        private List<Talleres> talleres = null;

        /**
         * No args constructor for use in serialization
         *
         */
        public ResponseTalleres() {
        }

        /**
         *
         * @param talleres
         */
        public ResponseTalleres(List<Talleres> talleres) {
            super();
            this.talleres = talleres;
        }

        public List<Talleres> getTalleres() {
            return talleres;
        }

        public void setTalleres(List<Talleres> talleres) {
            this.talleres = talleres;
        }

        public ResponseTalleres withTalleres(List<Talleres> talleres) {
            this.talleres = talleres;
            return this;
        }

    }


