package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class HotelArrayList {
    private ArrayList<Hotel> listaHoteles;
    private static HotelArrayList hotelesArrayList;
    
    public HotelArrayList(ArrayList<Hotel> listaHoteles){
        this.listaHoteles = new ArrayList<>();
        this.listaHoteles = listaHoteles;
    }

    public ArrayList<Hotel> getListaHoteles() {
        return listaHoteles;
    }

    public void setListaHoteles(ArrayList<Hotel> listaHoteles) {
        this.listaHoteles = listaHoteles;
    }
    
    //JSON
    public String toArrayJson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        
        Gson gson = builder.create();
        String resp = gson.toJson(listaHoteles);
        
        return resp;
    }

    //STRING
    public String toJSON() {
        int contador = 0;
        String cadena = "{\n'hoteles': [";
        for (Hotel hoteles : listaHoteles) {
            int totalItems = listaHoteles.size();

            cadena += "\n{ 'ID':" + hoteles.getId_Hotel()
                    + ", 'NOMBRE':" + hoteles.getNombre()
                    + ", 'DESCRIPCION':" + hoteles.getDescripcion()
                    + ", 'PAIS':" + hoteles.getPais()
                    + ", 'UBICACION':" + hoteles.getUbicacion()
                    + ", 'URL':" + hoteles.getUrl()
                    + ", 'HABITACIONES':" + hoteles.getHabitaciones() 
                    + ", 'PUNTUACION':" + hoteles.getPuntuacion() + "}"; 
            contador++;

            if (contador != totalItems) {
                cadena += ",";
            }
            // Si es i-1
        }
        cadena += "\n]\n}";
        return cadena;
    }
}