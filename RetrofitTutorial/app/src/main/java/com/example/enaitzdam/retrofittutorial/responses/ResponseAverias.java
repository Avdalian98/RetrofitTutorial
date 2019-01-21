package com.example.enaitzdam.retrofittutorial.responses;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseAverias {



        @SerializedName("averias")
        @Expose
        private List<Averias> averias = null;

        /**
         * No args constructor for use in serialization
         *
         */
        public ResponseAverias() {
        }

        /**
         *
         * @param averias
         */
        public ResponseAverias(List<Averias> averias) {
            super();
            this.averias = averias;
        }

        public List<Averias> getAverias() {
            return averias;
        }

        public void setAverias(List<Averias> averias) {
            this.averias = averias;
        }

        public ResponseAverias withAverias(List<Averias> averias) {
            this.averias = averias;
            return this;
        }

    }

